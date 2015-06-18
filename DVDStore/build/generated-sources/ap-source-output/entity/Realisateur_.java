package entity;

import entity.Dvd;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-07T05:40:19")
@StaticMetamodel(Realisateur.class)
public class Realisateur_ { 

    public static volatile SingularAttribute<Realisateur, Integer> id;
    public static volatile SingularAttribute<Realisateur, String> phone;
    public static volatile CollectionAttribute<Realisateur, Dvd> dvdCollection;
    public static volatile SingularAttribute<Realisateur, String> address;
    public static volatile SingularAttribute<Realisateur, String> name;
    public static volatile SingularAttribute<Realisateur, String> compagny;

}