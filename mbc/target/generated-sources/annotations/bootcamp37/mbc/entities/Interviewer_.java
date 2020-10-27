package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.Schedule;
import bootcamp37.mbc.entities.Site;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(Interviewer.class)
public class Interviewer_ { 

    public static volatile SingularAttribute<Interviewer, String> phoneNumber;
    public static volatile ListAttribute<Interviewer, Schedule> scheduleList;
    public static volatile SingularAttribute<Interviewer, String> name;
    public static volatile SingularAttribute<Interviewer, String> id;
    public static volatile SingularAttribute<Interviewer, String> email;
    public static volatile ListAttribute<Interviewer, Site> siteList;

}