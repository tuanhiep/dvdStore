package entity;

import entity.Commande;
import entity.Fournisseur;
import entity.SousCommandeHasDvd;
import entity.SousCommandePK;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-07T05:40:19")
@StaticMetamodel(SousCommande.class)
public class SousCommande_ { 

    public static volatile SingularAttribute<SousCommande, SousCommandePK> sousCommandePK;
    public static volatile SingularAttribute<SousCommande, Fournisseur> fournisseur;
    public static volatile SingularAttribute<SousCommande, String> state;
    public static volatile SingularAttribute<SousCommande, Commande> commande;
    public static volatile CollectionAttribute<SousCommande, SousCommandeHasDvd> sousCommandeHasDvdCollection;

}