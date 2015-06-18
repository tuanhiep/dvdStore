/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Strong man
 */
@Embeddable
public class SousCommandePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "commande_id")
    private int commandeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fournisseur_id")
    private int fournisseurId;

    public SousCommandePK() {
    }

    public SousCommandePK(int commandeId, int fournisseurId) {
        this.commandeId = commandeId;
        this.fournisseurId = fournisseurId;
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    public int getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(int fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) commandeId;
        hash += (int) fournisseurId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousCommandePK)) {
            return false;
        }
        SousCommandePK other = (SousCommandePK) object;
        if (this.commandeId != other.commandeId) {
            return false;
        }
        if (this.fournisseurId != other.fournisseurId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SousCommandePK[ commandeId=" + commandeId + ", fournisseurId=" + fournisseurId + " ]";
    }
    
}
