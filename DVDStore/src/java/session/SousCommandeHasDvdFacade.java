/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.SousCommandeHasDvd;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Strong man
 */
@Stateless
public class SousCommandeHasDvdFacade extends AbstractFacade<SousCommandeHasDvd> {
    @PersistenceContext(unitName = "DVDStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SousCommandeHasDvdFacade() {
        super(SousCommandeHasDvd.class);
    }
    
}
