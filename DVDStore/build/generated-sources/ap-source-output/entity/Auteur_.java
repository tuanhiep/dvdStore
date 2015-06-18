package entity;

import entity.Dvd;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-07T05:40:19")
@StaticMetamodel(Auteur.class)
public class Auteur_ { 

    public static volatile SingularAttribute<Auteur, Integer> id;
    public static volatile SingularAttribute<Auteur, String> phone;
    public static volatile CollectionAttribute<Auteur, Dvd> dvdCollection;
    public static volatile SingularAttribute<Auteur, String> address;
    public static volatile SingularAttribute<Auteur, String> name;
    public static volatile SingularAttribute<Auteur, String> compagny;

}