package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.Class;
import bootcamp37.mbc.entities.Course;
import bootcamp37.mbc.entities.Employee;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(Batch.class)
public class Batch_ { 

    public static volatile SingularAttribute<Batch, Date> endDate;
    public static volatile SingularAttribute<Batch, String> name;
    public static volatile SingularAttribute<Batch, Course> course;
    public static volatile SingularAttribute<Batch, Employee> employeeId;
    public static volatile SingularAttribute<Batch, String> id;
    public static volatile SingularAttribute<Batch, Employee> employee;
    public static volatile SingularAttribute<Batch, Course> courseId;
    public static volatile SingularAttribute<Batch, Date> startDate;
    public static volatile ListAttribute<Batch, Class> classList;

}