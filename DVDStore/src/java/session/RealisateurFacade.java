/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Realisateur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Strong man
 */
@Stateless
public class RealisateurFacade extends AbstractFacade<Realisateur> {

    @PersistenceContext(unitName = "DVDStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RealisateurFacade() {
        super(Realisateur.class);
    }

    public Realisateur getByID(int id) {
        List<Realisateur> list = this.findAll();

        for (Realisateur rea : list) {
            if (rea.getId() == id) {
                return rea;
            }
        }
        return null;
    }

}
