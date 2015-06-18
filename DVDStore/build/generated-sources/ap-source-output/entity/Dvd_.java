package entity;

import entity.Auteur;
import entity.DvdCommande;
import entity.Fournisseur;
import entity.Realisateur;
import entity.SousCommandeHasDvd;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-07T05:40:19")
@StaticMetamodel(Dvd.class)
public class Dvd_ { 

    public static volatile SingularAttribute<Dvd, Integer> id;
    public static volatile SingularAttribute<Dvd, Realisateur> realisateurId;
    public static volatile SingularAttribute<Dvd, BigDecimal> price;
    public static volatile SingularAttribute<Dvd, String> description;
    public static volatile CollectionAttribute<Dvd, DvdCommande> dvdCommandeCollection;
    public static volatile SingularAttribute<Dvd, Fournisseur> fournisseurId;
    public static volatile SingularAttribute<Dvd, String> name;
    public static volatile SingularAttribute<Dvd, Integer> quantitystock;
    public static volatile CollectionAttribute<Dvd, SousCommandeHasDvd> sousCommandeHasDvdCollection;
    public static volatile SingularAttribute<Dvd, Date> lastRelease;
    public static volatile SingularAttribute<Dvd, Auteur> auteurId;

}