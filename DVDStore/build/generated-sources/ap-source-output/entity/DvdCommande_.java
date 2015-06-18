package entity;

import entity.Commande;
import entity.Dvd;
import entity.DvdCommandePK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-07T05:40:19")
@StaticMetamodel(DvdCommande.class)
public class DvdCommande_ { 

    public static volatile SingularAttribute<DvdCommande, DvdCommandePK> dvdCommandePK;
    public static volatile SingularAttribute<DvdCommande, Dvd> dvd;
    public static volatile SingularAttribute<DvdCommande, Integer> quantity;
    public static volatile SingularAttribute<DvdCommande, Commande> commande;

}