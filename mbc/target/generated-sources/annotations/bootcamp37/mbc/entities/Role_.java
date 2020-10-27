package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.UserRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, String> name;
    public static volatile SingularAttribute<Role, String> id;
    public static volatile ListAttribute<Role, UserRole> userRoleList;

}