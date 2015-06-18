/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package management;

import entity.Commande;

/**
 *
 * @author Strong man
 */
public class CommandeAndCount implements Comparable<CommandeAndCount> {
    
    private Commande commande;
    private int count;

    public CommandeAndCount(Commande commande, int count) {
        this.commande = commande;
        this.count = count;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

   
    @Override
    public int compareTo(CommandeAndCount com) {
       return (this.commande.getId() < com.commande.getId() ) ? -1: (this.commande.getId() > com.commande.getId() ) ? 1:0 ;
    }
    
    
    
    
    
}
