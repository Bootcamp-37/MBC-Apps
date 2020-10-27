package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.Batch;
import bootcamp37.mbc.entities.Class;
import bootcamp37.mbc.entities.Placement;
import bootcamp37.mbc.entities.Skills;
import bootcamp37.mbc.entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Date> hireDate;
    public static volatile SingularAttribute<Employee, String> address;
    public static volatile SingularAttribute<Employee, String> gender;
    public static volatile SingularAttribute<Employee, Date> endDate;
    public static volatile ListAttribute<Employee, Placement> placementList;
    public static volatile SingularAttribute<Employee, Date> birthDate;
    public static volatile SingularAttribute<Employee, String> phoneNumber;
    public static volatile SingularAttribute<Employee, String> name;
    public static volatile ListAttribute<Employee, Skills> skillsList;
    public static volatile SingularAttribute<Employee, String> id;
    public static volatile ListAttribute<Employee, Batch> batchList;
    public static volatile SingularAttribute<Employee, User> user;
    public static volatile SingularAttribute<Employee, String> email;
    public static volatile ListAttribute<Employee, Class> classList;

}