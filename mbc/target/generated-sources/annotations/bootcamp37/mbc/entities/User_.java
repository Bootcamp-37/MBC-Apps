package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.Employee;
import bootcamp37.mbc.entities.UserRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> id;
    public static volatile SingularAttribute<User, Employee> employee;
    public static volatile ListAttribute<User, UserRole> userRoleList;
    public static volatile SingularAttribute<User, String> username;

}