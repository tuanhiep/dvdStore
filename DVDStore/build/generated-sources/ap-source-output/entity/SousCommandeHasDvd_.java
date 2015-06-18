package entity;

import entity.Dvd;
import entity.SousCommande;
import entity.SousCommandeHasDvdPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-07T05:40:19")
@StaticMetamodel(SousCommandeHasDvd.class)
public class SousCommandeHasDvd_ { 

    public static volatile SingularAttribute<SousCommandeHasDvd, SousCommande> sousCommande;
    public static volatile SingularAttribute<SousCommandeHasDvd, Dvd> dvd;
    public static volatile SingularAttribute<SousCommandeHasDvd, SousCommandeHasDvdPK> sousCommandeHasDvdPK;
    public static volatile SingularAttribute<SousCommandeHasDvd, Integer> missingquantity;

}