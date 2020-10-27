package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.Role;
import bootcamp37.mbc.entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(UserRole.class)
public class UserRole_ { 

    public static volatile SingularAttribute<UserRole, User> idUser;
    public static volatile SingularAttribute<UserRole, Role> role;
    public static volatile SingularAttribute<UserRole, Role> idRole;
    public static volatile SingularAttribute<UserRole, String> id;
    public static volatile SingularAttribute<UserRole, User> user;

}