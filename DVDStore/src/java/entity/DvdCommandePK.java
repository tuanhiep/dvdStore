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
public class DvdCommandePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "commande_id")
    private int commandeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dvd_id")
    private int dvdId;

    public DvdCommandePK() {
    }

    public DvdCommandePK(int commandeId, int dvdId) {
        this.commandeId = commandeId;
        this.dvdId = dvdId;
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
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
        hash += (int) commandeId;
        hash += (int) dvdId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DvdCommandePK)) {
            return false;
        }
        DvdCommandePK other = (DvdCommandePK) object;
        if (this.commandeId != other.commandeId) {
            return false;
        }
        if (this.dvdId != other.dvdId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DvdCommandePK[ commandeId=" + commandeId + ", dvdId=" + dvdId + " ]";
    }
    
}
