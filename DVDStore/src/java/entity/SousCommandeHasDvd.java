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
import javax.persistence.JoinColumns;
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
@Table(name = "sous_commande_has_dvd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SousCommandeHasDvd.findAll", query = "SELECT s FROM SousCommandeHasDvd s"),
    @NamedQuery(name = "SousCommandeHasDvd.findBySousCommandeCommandeId", query = "SELECT s FROM SousCommandeHasDvd s WHERE s.sousCommandeHasDvdPK.sousCommandeCommandeId = :sousCommandeCommandeId"),
    @NamedQuery(name = "SousCommandeHasDvd.findBySousCommandeFournisseurId", query = "SELECT s FROM SousCommandeHasDvd s WHERE s.sousCommandeHasDvdPK.sousCommandeFournisseurId = :sousCommandeFournisseurId"),
    @NamedQuery(name = "SousCommandeHasDvd.findByDvdId", query = "SELECT s FROM SousCommandeHasDvd s WHERE s.sousCommandeHasDvdPK.dvdId = :dvdId"),
    @NamedQuery(name = "SousCommandeHasDvd.findByMissingquantity", query = "SELECT s FROM SousCommandeHasDvd s WHERE s.missingquantity = :missingquantity")})
public class SousCommandeHasDvd implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SousCommandeHasDvdPK sousCommandeHasDvdPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "missingquantity")
    private int missingquantity;
    @JoinColumn(name = "dvd_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dvd dvd;
    @JoinColumns({
        @JoinColumn(name = "sous_commande_commande_id", referencedColumnName = "commande_id", insertable = false, updatable = false),
        @JoinColumn(name = "sous_commande_fournisseur_id", referencedColumnName = "fournisseur_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SousCommande sousCommande;

    public SousCommandeHasDvd() {
    }

    public SousCommandeHasDvd(SousCommandeHasDvdPK sousCommandeHasDvdPK) {
        this.sousCommandeHasDvdPK = sousCommandeHasDvdPK;
    }

    public SousCommandeHasDvd(SousCommandeHasDvdPK sousCommandeHasDvdPK, int missingquantity) {
        this.sousCommandeHasDvdPK = sousCommandeHasDvdPK;
        this.missingquantity = missingquantity;
    }

    public SousCommandeHasDvd(int sousCommandeCommandeId, int sousCommandeFournisseurId, int dvdId) {
        this.sousCommandeHasDvdPK = new SousCommandeHasDvdPK(sousCommandeCommandeId, sousCommandeFournisseurId, dvdId);
    }

    public SousCommandeHasDvdPK getSousCommandeHasDvdPK() {
        return sousCommandeHasDvdPK;
    }

    public void setSousCommandeHasDvdPK(SousCommandeHasDvdPK sousCommandeHasDvdPK) {
        this.sousCommandeHasDvdPK = sousCommandeHasDvdPK;
    }

    public int getMissingquantity() {
        return missingquantity;
    }

    public void setMissingquantity(int missingquantity) {
        this.missingquantity = missingquantity;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public SousCommande getSousCommande() {
        return sousCommande;
    }

    public void setSousCommande(SousCommande sousCommande) {
        this.sousCommande = sousCommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sousCommandeHasDvdPK != null ? sousCommandeHasDvdPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousCommandeHasDvd)) {
            return false;
        }
        SousCommandeHasDvd other = (SousCommandeHasDvd) object;
        if ((this.sousCommandeHasDvdPK == null && other.sousCommandeHasDvdPK != null) || (this.sousCommandeHasDvdPK != null && !this.sousCommandeHasDvdPK.equals(other.sousCommandeHasDvdPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SousCommandeHasDvd[ sousCommandeHasDvdPK=" + sousCommandeHasDvdPK + " ]";
    }
    
}
