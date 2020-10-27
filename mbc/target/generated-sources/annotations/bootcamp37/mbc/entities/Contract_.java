package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.Placement;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(Contract.class)
public class Contract_ { 

    public static volatile SingularAttribute<Contract, Date> endDate;
    public static volatile ListAttribute<Contract, Placement> placementList;
    public static volatile SingularAttribute<Contract, String> name;
    public static volatile SingularAttribute<Contract, String> id;
    public static volatile SingularAttribute<Contract, Date> startDate;

}