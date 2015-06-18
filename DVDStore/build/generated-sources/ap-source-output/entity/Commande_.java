package entity;

import entity.Client;
import entity.DvdCommande;
import entity.SousCommande;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-07T05:40:19")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, Integer> id;
    public static volatile SingularAttribute<Commande, BigDecimal> amount;
    public static volatile CollectionAttribute<Commande, DvdCommande> dvdCommandeCollection;
    public static volatile SingularAttribute<Commande, Integer> confirmationNumber;
    public static volatile SingularAttribute<Commande, String> state;
    public static volatile CollectionAttribute<Commande, SousCommande> sousCommandeCollection;
    public static volatile SingularAttribute<Commande, Date> dateCreated;
    public static volatile SingularAttribute<Commande, Client> clientId;

}