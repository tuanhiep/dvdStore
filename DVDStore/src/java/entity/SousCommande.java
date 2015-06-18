/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Strong man
 */
@Entity
@Table(name = "sous_commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SousCommande.findAll", query = "SELECT s FROM SousCommande s"),
    @NamedQuery(name = "SousCommande.findByCommandeId", query = "SELECT s FROM SousCommande s WHERE s.sousCommandePK.commandeId = :commandeId"),
    @NamedQuery(name = "SousCommande.findByFournisseurId", query = "SELECT s FROM SousCommande s WHERE s.sousCommandePK.fournisseurId = :fournisseurId"),
    @NamedQuery(name = "SousCommande.findByState", query = "SELECT s FROM SousCommande s WHERE s.state = :state")})
public class SousCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SousCommandePK sousCommandePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "state")
    private String state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sousCommande")
    private Collection<SousCommandeHasDvd> sousCommandeHasDvdCollection;
    @JoinColumn(name = "fournisseur_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fournisseur fournisseur;
    @JoinColumn(name = "commande_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;

    public SousCommande() {
    }

    public SousCommande(SousCommandePK sousCommandePK) {
        this.sousCommandePK = sousCommandePK;
    }

    public SousCommande(SousCommandePK sousCommandePK, String state) {
        this.sousCommandePK = sousCommandePK;
        this.state = state;
    }

    public SousCommande(int commandeId, int fournisseurId) {
        this.sousCommandePK = new SousCommandePK(commandeId, fournisseurId);
    }

    public SousCommandePK getSousCommandePK() {
        return sousCommandePK;
    }

    public void setSousCommandePK(SousCommandePK sousCommandePK) {
        this.sousCommandePK = sousCommandePK;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<SousCommandeHasDvd> getSousCommandeHasDvdCollection() {
        return sousCommandeHasDvdCollection;
    }

    public void setSousCommandeHasDvdCollection(Collection<SousCommandeHasDvd> sousCommandeHasDvdCollection) {
        this.sousCommandeHasDvdCollection = sousCommandeHasDvdCollection;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
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
        hash += (sousCommandePK != null ? sousCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousCommande)) {
            return false;
        }
        SousCommande other = (SousCommande) object;
        if ((this.sousCommandePK == null && other.sousCommandePK != null) || (this.sousCommandePK != null && !this.sousCommandePK.equals(other.sousCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SousCommande[ sousCommandePK=" + sousCommandePK + " ]";
    }
    
}
