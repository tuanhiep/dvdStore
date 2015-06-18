package entity;

import entity.Commande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-07T05:40:19")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> phone;
    public static volatile SingularAttribute<Client, String> address;
    public static volatile SingularAttribute<Client, String> email;
    public static volatile SingularAttribute<Client, String> ccNumber;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile CollectionAttribute<Client, Commande> commandeCollection;

}