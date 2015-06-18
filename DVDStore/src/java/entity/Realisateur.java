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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "realisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Realisateur.findAll", query = "SELECT r FROM Realisateur r"),
    @NamedQuery(name = "Realisateur.findById", query = "SELECT r FROM Realisateur r WHERE r.id = :id"),
    @NamedQuery(name = "Realisateur.findByName", query = "SELECT r FROM Realisateur r WHERE r.name = :name"),
    @NamedQuery(name = "Realisateur.findByPhone", query = "SELECT r FROM Realisateur r WHERE r.phone = :phone"),
    @NamedQuery(name = "Realisateur.findByAddress", query = "SELECT r FROM Realisateur r WHERE r.address = :address"),
    @NamedQuery(name = "Realisateur.findByCompagny", query = "SELECT r FROM Realisateur r WHERE r.compagny = :compagny")})
public class Realisateur implements Serializable {
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
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "phone")
    private String phone;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "compagny")
    private String compagny;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "realisateurId")
    private Collection<Dvd> dvdCollection;

    public Realisateur() {
    }

    public Realisateur(Integer id) {
        this.id = id;
    }

    public Realisateur(Integer id, String name, String compagny) {
        this.id = id;
        this.name = name;
        this.compagny = compagny;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompagny() {
        return compagny;
    }

    public void setCompagny(String compagny) {
        this.compagny = compagny;
    }

    @XmlTransient
    public Collection<Dvd> getDvdCollection() {
        return dvdCollection;
    }

    public void setDvdCollection(Collection<Dvd> dvdCollection) {
        this.dvdCollection = dvdCollection;
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
        if (!(object instanceof Realisateur)) {
            return false;
        }
        Realisateur other = (Realisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Realisateur[ id=" + id + " ]";
    }
    
}
