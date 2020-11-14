package bootcamp37.mbc.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, Date> hireDate;
	public static volatile SingularAttribute<Employee, String> phoneNumber;
	public static volatile SingularAttribute<Employee, String> address;
	public static volatile SingularAttribute<Employee, String> gender;
	public static volatile SingularAttribute<Employee, Date> endDate;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, String> id;
	public static volatile SingularAttribute<Employee, Date> birthDate;
	public static volatile SingularAttribute<Employee, User> user;
	public static volatile SingularAttribute<Employee, String> email;

}

