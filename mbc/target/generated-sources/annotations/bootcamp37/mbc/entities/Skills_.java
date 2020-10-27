package bootcamp37.mbc.entities;

import bootcamp37.mbc.entities.Employee;
import bootcamp37.mbc.entities.Request;
import bootcamp37.mbc.entities.SkillsSet;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-27T10:58:39")
@StaticMetamodel(Skills.class)
public class Skills_ { 

    public static volatile ListAttribute<Skills, Request> requestList;
    public static volatile SingularAttribute<Skills, SkillsSet> skillsSetId;
    public static volatile SingularAttribute<Skills, Employee> employeeId;
    public static volatile SingularAttribute<Skills, String> id;
    public static volatile SingularAttribute<Skills, Employee> employee;
    public static volatile SingularAttribute<Skills, SkillsSet> skillsSet;

}