package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.Placement;
import bootcamp37.mbc.entities.Schedule;
import bootcamp37.mbc.entities.Site;
import bootcamp37.mbc.entities.Skills;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(Request.class)
public class Request_ { 

    public static volatile SingularAttribute<Request, Skills> skills;
    public static volatile SingularAttribute<Request, Schedule> schedule;
    public static volatile SingularAttribute<Request, Site> site;
    public static volatile ListAttribute<Request, Placement> placementList;
    public static volatile SingularAttribute<Request, Site> siteId;
    public static volatile SingularAttribute<Request, String> id;
    public static volatile SingularAttribute<Request, Integer> workerDemand;
    public static volatile SingularAttribute<Request, Schedule> scheduleId;
    public static volatile SingularAttribute<Request, Skills> skillsId;
    public static volatile SingularAttribute<Request, String> status;

}