/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Strong man
 */
@Entity
@Table(name = "dvd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dvd.findAll", query = "SELECT d FROM Dvd d"),
    @NamedQuery(name = "Dvd.findById", query = "SELECT d FROM Dvd d WHERE d.id = :id"),
    @NamedQuery(name = "Dvd.findByName", query = "SELECT d FROM Dvd d WHERE d.name = :name"),
    @NamedQuery(name = "Dvd.findByPrice", query = "SELECT d FROM Dvd d WHERE d.price = :price"),
    @NamedQuery(name = "Dvd.findByDescription", query = "SELECT d FROM Dvd d WHERE d.description = :description"),
    @NamedQuery(name = "Dvd.findByLastRelease", query = "SELECT d FROM Dvd d WHERE d.lastRelease = :lastRelease"),
    @NamedQuery(name = "Dvd.findByQuantitystock", query = "SELECT d FROM Dvd d WHERE d.quantitystock = :quantitystock")})
public class Dvd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_release")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastRelease;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantitystock")
    private int quantitystock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dvd")
    private Collection<DvdCommande> dvdCommandeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dvd")
    private Collection<SousCommandeHasDvd> sousCommandeHasDvdCollection;
    @JoinColumn(name = "fournisseur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Fournisseur fournisseurId;
    @JoinColumn(name = "auteur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Auteur auteurId;
    @JoinColumn(name = "realisateur_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Realisateur realisateurId;

    public Dvd() {
    }

    public Dvd(Integer id) {
        this.id = id;
    }

    public Dvd(Integer id, String name, BigDecimal price, Date lastRelease, int quantitystock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.lastRelease = lastRelease;
        this.quantitystock = quantitystock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastRelease() {
        return lastRelease;
    }

    public void setLastRelease(Date lastRelease) {
        this.lastRelease = lastRelease;
    }

    public int getQuantitystock() {
        return quantitystock;
    }

    public void setQuantitystock(int quantitystock) {
        this.quantitystock = quantitystock;
    }

    @XmlTransient
    public Collection<DvdCommande> getDvdCommandeCollection() {
        return dvdCommandeCollection;
    }

    public void setDvdCommandeCollection(Collection<DvdCommande> dvdCommandeCollection) {
        this.dvdCommandeCollection = dvdCommandeCollection;
    }

    @XmlTransient
    public Collection<SousCommandeHasDvd> getSousCommandeHasDvdCollection() {
        return sousCommandeHasDvdCollection;
    }

    public void setSousCommandeHasDvdCollection(Collection<SousCommandeHasDvd> sousCommandeHasDvdCollection) {
        this.sousCommandeHasDvdCollection = sousCommandeHasDvdCollection;
    }

    public Fournisseur getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Fournisseur fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public Auteur getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(Auteur auteurId) {
        this.auteurId = auteurId;
    }

    public Realisateur getRealisateurId() {
        return realisateurId;
    }

    public void setRealisateurId(Realisateur realisateurId) {
        this.realisateurId = realisateurId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dvd)) {
            return false;
        }
        Dvd other = (Dvd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dvd[ id=" + id + " ]";
    }
    
}
