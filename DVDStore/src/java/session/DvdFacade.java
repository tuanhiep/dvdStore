/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Auteur;
import entity.Dvd;
import entity.Fournisseur;
import entity.Realisateur;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.transaction.Transactional;

/**
 *
 * @author Strong man
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DvdFacade extends AbstractFacade<Dvd> {

    @PersistenceContext(unitName = "DVDStorePU")
    private EntityManager em;

    @EJB
    AuteurFacade auteurFacade;
    @EJB
    RealisateurFacade realisateurFacade;
    @EJB
    FournisseurFacade fournisseurFacade;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public DvdFacade() {
        super(Dvd.class);
    }

    /**
     * Get dvds by searching name of dvd
     *
     * @param name
     * @return list of dvd
     */
    public List<Dvd> getByName(String name) {

        List<Dvd> list = this.findAll();
        ArrayList<Dvd> result = new ArrayList<>();
        for (Dvd d : list) {

            if (d.getName().toLowerCase().contains(name.toLowerCase())) {

                result.add(d);
            }
        }

        return result;

    }

    /**
     * Get Dvd by the searching the Auteur of Dvd
     *
     * @param nameAuteur
     * @return List of Dvds
     */
    public List<Dvd> getByAuteur(String nameAuteur) {

        List<Dvd> list = this.findAll();
        ArrayList<Dvd> result = new ArrayList<>();

        for (Dvd d : list) {

            if ((d.getAuteurId().getName()).toLowerCase().contains(nameAuteur.toLowerCase())) {
                result.add(d);
            }
        }

        return result;

    }

    /**
     * Get Dvd by searching name of Realisateur of Dvd
     *
     * @param nameReal
     * @return List of Dvds
     */
    public List<Dvd> getByRealisateur(String nameReal) {

        List<Dvd> list = this.findAll();
        ArrayList<Dvd> result = new ArrayList<>();

        for (Dvd d : list) {

            if (d.getRealisateurId().getName().toLowerCase().contains(nameReal.toLowerCase())) {

                result.add(d);
            }
        }

        return result;
    }

    public int getMaxID() {
        List<Dvd> list = this.findAll();
        return list.get(list.size() - 1).getId();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int addDvd(String name, String price, String quantity, String description, String auteurId, String fournisseurId, String realisateurId) {
        try {

            Dvd dvd = new Dvd();
            dvd.setName(name);
            dvd.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
            dvd.setQuantitystock(Integer.parseInt(quantity));
            dvd.setDescription(description);
            Auteur selectedAuteur = auteurFacade.find(Integer.parseInt(auteurId));
            dvd.setAuteurId(selectedAuteur);
            Fournisseur selectedFournisseur = fournisseurFacade.find(Integer.parseInt(fournisseurId));
            dvd.setFournisseurId(selectedFournisseur);
            Realisateur selectedRealisateur = realisateurFacade.find(Integer.parseInt(realisateurId));
            dvd.setRealisateurId(selectedRealisateur);
            dvd.setLastRelease(new Date());
            em.persist(dvd);
            em.flush();
            return dvd.getId();
        } catch (Exception e) {
            return 0;
        }
    }
    
    @Override
    public void remove(Dvd entity){
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().flush();
    }

}
