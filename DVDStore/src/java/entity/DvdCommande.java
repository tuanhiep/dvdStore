/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Strong man
 */
@Entity
@Table(name = "dvd_commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DvdCommande.findAll", query = "SELECT d FROM DvdCommande d"),
    @NamedQuery(name = "DvdCommande.findByCommandeId", query = "SELECT d FROM DvdCommande d WHERE d.dvdCommandePK.commandeId = :commandeId"),
    @NamedQuery(name = "DvdCommande.findByDvdId", query = "SELECT d FROM DvdCommande d WHERE d.dvdCommandePK.dvdId = :dvdId"),
    @NamedQuery(name = "DvdCommande.findByQuantity", query = "SELECT d FROM DvdCommande d WHERE d.quantity = :quantity")})
public class DvdCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DvdCommandePK dvdCommandePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "dvd_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dvd dvd;
    @JoinColumn(name = "commande_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;

    public DvdCommande() {
    }

    public DvdCommande(DvdCommandePK dvdCommandePK) {
        this.dvdCommandePK = dvdCommandePK;
    }

    public DvdCommande(DvdCommandePK dvdCommandePK, int quantity) {
        this.dvdCommandePK = dvdCommandePK;
        this.quantity = quantity;
    }

    public DvdCommande(int commandeId, int dvdId) {
        this.dvdCommandePK = new DvdCommandePK(commandeId, dvdId);
    }

    public DvdCommandePK getDvdCommandePK() {
        return dvdCommandePK;
    }

    public void setDvdCommandePK(DvdCommandePK dvdCommandePK) {
        this.dvdCommandePK = dvdCommandePK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dvdCommandePK != null ? dvdCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DvdCommande)) {
            return false;
        }
        DvdCommande other = (DvdCommande) object;
        if ((this.dvdCommandePK == null && other.dvdCommandePK != null) || (this.dvdCommandePK != null && !this.dvdCommandePK.equals(other.dvdCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DvdCommande[ dvdCommandePK=" + dvdCommandePK + " ]";
    }
    
}
