/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.DvdCommande;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Strong man
 */
@Stateless
public class DvdCommandeFacade extends AbstractFacade<DvdCommande> {
    @PersistenceContext(unitName = "DVDStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DvdCommandeFacade() {
        super(DvdCommande.class);
    }
    
    // manually created
    public List<DvdCommande> findByCommandeId(Object id) {
        
        return em.createNamedQuery("DvdCommande.findByCommandeId").setParameter("commandeId", id).getResultList();
       
    }
}
