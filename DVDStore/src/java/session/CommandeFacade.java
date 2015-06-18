/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Commande;
import entity.Dvd;
import entity.DvdCommande;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import management.CommandeAndCount;
import management.MissingDvd;

/**
 *
 * @author Strong man
 */
@Stateless
//@TransactionManagement(TransactionManagementType.CONTAINER)
public class CommandeFacade extends AbstractFacade<Commande> {

    @PersistenceContext(unitName = "DVDStorePU")
    private EntityManager em;
    @EJB
    private DvdFacade dvdFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }

    public void setStateByCommandeID(int commandeId, String state) {

        this.find(commandeId).setState(state);

    }

    /**
     * Get pending commandes
     *
     * @return list of pending commandes
     */
    public List<Commande> getOngoingCommande() {

        List<Commande> commandes = this.findAll();
        List<Commande> ongoing = new ArrayList<>();
        for (Commande c : commandes) {

            if ("ongoing".equals(c.getState())) {

                ongoing.add(c);
            }

        }
        return ongoing;

    }

    /**
     * Get pending commandes
     *
     * @return list of pending commandes
     */
    public List<Commande> getPendingCommande() {

        List<Commande> commandes = this.findAll();
        List<Commande> pendings = new ArrayList<>();
        for (Commande c : commandes) {

            if ("pending".equals(c.getState())) {
                pendings.add(c);
            }
        }
        return pendings;
    }

    /**
     * Get pending commandes
     *
     * @return list of pending commandes
     */
    public List<Commande> getExecutedCommande() {

        List<Commande> commandes = this.findAll();
        List<Commande> executed = new ArrayList<>();
        for (Commande c : commandes) {

            if ("executed".equals(c.getState())) {

                executed.add(c);
            }

        }
        return executed;

    }

    public void setOngoingByCommandeId(Integer CommandeId) {

        this.find(CommandeId).setState("ongoing");
    }

    public void setOngoingByListOfCommandes(List<Commande> list) {

        for (Commande c : list) {
            this.setOngoingByCommandeId(c.getId());
        }
    }

    public void setExecutedByCommandeId(Integer CommandeId) {

        this.find(CommandeId).setState("executed");
    }

    public void setExecutedByListOfCommandes(List<Commande> list) {

        for (Commande c : list) {

            this.setExecutedByCommandeId(c.getId());

        }
    }

    /**
     * Get the pending Command with it's pending DVDs
     *
     * @return
     */
//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Map processCommande() {

        Map pendingMap = new TreeMap();
        List<Commande> commandes = this.findAll();
        HashMap<Dvd, Integer> quantityMap = new HashMap<>();
        List<Dvd> dvds = dvdFacade.findAll();
        for (Dvd d : dvds) {
            quantityMap.put(d, d.getQuantitystock());
        }
        for (Commande c : commandes) {

            if (!"executed".equals(c.getState())) {

                // processe c 
                CommandeAndCount cc = new CommandeAndCount(c, 0);
                List<MissingDvd> lm = new ArrayList<>();
                List<DvdCommande> dvdCommande = new ArrayList(c.getDvdCommandeCollection());

                int gam, missInCommande;
                for (DvdCommande dc : dvdCommande) {

                    gam = quantityMap.get(dc.getDvd()) - dc.getQuantity();
                    if (quantityMap.get(dc.getDvd()) > 0) {
                        missInCommande = -gam;
                    } else {
                        missInCommande = dc.getQuantity();
                    }
                    // quantity rest in stock
                    quantityMap.put(dc.getDvd(), gam);
                    // Dvds are not enough in stock
                    if (gam < 0) {
                        // Add the MissingDVD into the missing list correspond to commande c
                        lm.add(new MissingDvd(dc.getDvd(), missInCommande));
                        int count = cc.getCount() + 1;
                        cc.setCount(count);
                    }

                }

                if (!lm.isEmpty()) {
                    pendingMap.put(cc, lm);
                    c.setState("pending");
                   
                    this.edit(c);
                } else {
                    c.setState("ongoing");
                  
                    this.edit(c);
                }
            }

        }

        return pendingMap;
    }

}
