package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.Interviewer;
import bootcamp37.mbc.entities.Request;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(Schedule.class)
public class Schedule_ { 

    public static volatile SingularAttribute<Schedule, Interviewer> interviewer;
    public static volatile SingularAttribute<Schedule, Date> date;
    public static volatile ListAttribute<Schedule, Request> requestList;
    public static volatile SingularAttribute<Schedule, String> id;
    public static volatile SingularAttribute<Schedule, Interviewer> interviewerId;

}