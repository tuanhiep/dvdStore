package session;

import cart.ShoppingCart;
import cart.ShoppingCartItem;
import entity.Client;
import entity.Commande;
import entity.Dvd;
import entity.DvdCommande;
import entity.DvdCommandePK;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Strong man
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderManager {

    @PersistenceContext(unitName = "DVDStorePU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private CommandeFacade commandeFacade;
    @EJB
    private DvdCommandeFacade dvdCommandeFacade;
    @EJB
    private DvdFacade dvdFacade;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int FaireCommande(String name, String email, String phone, String address, String ccNumber, ShoppingCart cart) {
        try {
            Client client = addClient(name, email, phone, address, ccNumber);
            Commande commande = addCommande(client, cart);
            addDvdCommandes(commande, cart);
            return commande.getId();
        } catch (Exception e) {
            context.setRollbackOnly();
            return 0;
        }

    }

    private void addDvdCommandes(Commande commande, ShoppingCart cart) {

        em.flush();
        List<ShoppingCartItem> items = cart.getItems();

        // iterate through shopping cart and create OrderedProducts
        for (ShoppingCartItem scItem : items) {

            int dvdId = scItem.getDvd().getId();

            // set up primary key object
            DvdCommandePK dvdCommandePK = new DvdCommandePK();
            dvdCommandePK.setCommandeId(commande.getId());
            dvdCommandePK.setDvdId(dvdId);
            // create ordered item using PK object

            DvdCommande dvdcommande = new DvdCommande(dvdCommandePK);
            dvdcommande.setQuantity(scItem.getQuantity());
            // put dvdcommande into persistent context
            em.persist(dvdcommande);

        }

    }

    private Client addClient(String name, String email, String phone, String address, String ccNumber) {
        Client client = new Client();
        client.setName(name);
        client.setEmail(email);
        client.setPhone(phone);
        client.setAddress(address);
        client.setCcNumber(ccNumber);
        // put client into persistent context
        em.persist(client);
        return client;

    }

    private Commande addCommande(Client client, ShoppingCart cart) {

        String state = "pending";
        // set up customer order
        Commande commande = new Commande();
        commande.setClientId(client);
        commande.setAmount(BigDecimal.valueOf(cart.getTotal()));
        // create confirmation number
        Random random = new Random();
        int i = random.nextInt(999999999);
        commande.setConfirmationNumber(i);
        commande.setDateCreated(new Date());
        commande.setState(state);
        // put commande into persistent context
        em.persist(commande);
        return commande;

    }

    public Map getCommandeDetails(int commandeId) {

        Map commandeMap = new HashMap();
        Commande commande = commandeFacade.find(commandeId);
        Client client = commande.getClientId();
        List<DvdCommande> dvdCommandes = dvdCommandeFacade.findByCommandeId(commandeId);
        List<Dvd> dvds = new ArrayList<>();

        for (DvdCommande dc : dvdCommandes) {
            Dvd d = dvdFacade.find(dc.getDvdCommandePK().getDvdId());
            dvds.add(d);

        }
        commandeMap.put("commandeRecord", commande);
        commandeMap.put("client", client);
        commandeMap.put("dvdCommandes", dvdCommandes);
        commandeMap.put("dvds", dvds);
        return commandeMap;

    }

}
