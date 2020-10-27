package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.Client;
import bootcamp37.mbc.entities.Interviewer;
import bootcamp37.mbc.entities.Request;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(Site.class)
public class Site_ { 

    public static volatile SingularAttribute<Site, String> division;
    public static volatile SingularAttribute<Site, Interviewer> interviewId;
    public static volatile SingularAttribute<Site, String> address;
    public static volatile SingularAttribute<Site, Client> clientId;
    public static volatile ListAttribute<Site, Request> requestList;
    public static volatile SingularAttribute<Site, String> name;
    public static volatile SingularAttribute<Site, Client> client;
    public static volatile SingularAttribute<Site, String> id;
    public static volatile SingularAttribute<Site, Interviewer> interview;
    public static volatile SingularAttribute<Site, String> phoneSite;

}