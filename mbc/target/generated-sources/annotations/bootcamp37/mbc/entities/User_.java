package bootcamp37.mbc.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> id;
	public static volatile SingularAttribute<User, Employee> employee;
	public static volatile ListAttribute<User, UserRole> userRoleList;
	public static volatile SingularAttribute<User, String> username;

}

