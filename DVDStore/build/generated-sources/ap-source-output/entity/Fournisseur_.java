package entity;

import entity.Dvd;
import entity.SousCommande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-07T05:40:19")
@StaticMetamodel(Fournisseur.class)
public class Fournisseur_ { 

    public static volatile SingularAttribute<Fournisseur, Integer> id;
    public static volatile SingularAttribute<Fournisseur, String> phone;
    public static volatile CollectionAttribute<Fournisseur, Dvd> dvdCollection;
    public static volatile SingularAttribute<Fournisseur, String> address;
    public static volatile SingularAttribute<Fournisseur, String> email;
    public static volatile SingularAttribute<Fournisseur, String> entreprise;
    public static volatile CollectionAttribute<Fournisseur, SousCommande> sousCommandeCollection;

}