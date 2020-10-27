package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.Contract;
import bootcamp37.mbc.entities.Employee;
import bootcamp37.mbc.entities.Request;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(Placement.class)
public class Placement_ { 

    public static volatile SingularAttribute<Placement, Request> request;
    public static volatile SingularAttribute<Placement, Request> requestId;
    public static volatile SingularAttribute<Placement, Contract> contract;
    public static volatile SingularAttribute<Placement, Contract> contractId;
    public static volatile SingularAttribute<Placement, Employee> employeeId;
    public static volatile SingularAttribute<Placement, String> id;
    public static volatile SingularAttribute<Placement, Employee> employee;
    public static volatile SingularAttribute<Placement, String> status;

}