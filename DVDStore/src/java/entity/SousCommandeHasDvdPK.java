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
public class SousCommandeHasDvdPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "sous_commande_commande_id")
    private int sousCommandeCommandeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sous_commande_fournisseur_id")
    private int sousCommandeFournisseurId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dvd_id")
    private int dvdId;

    public SousCommandeHasDvdPK() {
    }

    public SousCommandeHasDvdPK(int sousCommandeCommandeId, int sousCommandeFournisseurId, int dvdId) {
        this.sousCommandeCommandeId = sousCommandeCommandeId;
        this.sousCommandeFournisseurId = sousCommandeFournisseurId;
        this.dvdId = dvdId;
    }

    public int getSousCommandeCommandeId() {
        return sousCommandeCommandeId;
    }

    public void setSousCommandeCommandeId(int sousCommandeCommandeId) {
        this.sousCommandeCommandeId = sousCommandeCommandeId;
    }

    public int getSousCommandeFournisseurId() {
        return sousCommandeFournisseurId;
    }

    public void setSousCommandeFournisseurId(int sousCommandeFournisseurId) {
        this.sousCommandeFournisseurId = sousCommandeFournisseurId;
    }

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) sousCommandeCommandeId;
        hash += (int) sousCommandeFournisseurId;
        hash += (int) dvdId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousCommandeHasDvdPK)) {
            return false;
        }
        SousCommandeHasDvdPK other = (SousCommandeHasDvdPK) object;
        if (this.sousCommandeCommandeId != other.sousCommandeCommandeId) {
            return false;
        }
        if (this.sousCommandeFournisseurId != other.sousCommandeFournisseurId) {
            return false;
        }
        if (this.dvdId != other.dvdId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SousCommandeHasDvdPK[ sousCommandeCommandeId=" + sousCommandeCommandeId + ", sousCommandeFournisseurId=" + sousCommandeFournisseurId + ", dvdId=" + dvdId + " ]";
    }
    
}
