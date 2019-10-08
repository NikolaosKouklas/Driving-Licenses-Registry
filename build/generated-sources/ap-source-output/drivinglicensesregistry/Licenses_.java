package drivinglicensesregistry;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-08T18:53:17")
@StaticMetamodel(Licenses.class)
public class Licenses_ { 

    public static volatile SingularAttribute<Licenses, Integer> id;
    public static volatile SingularAttribute<Licenses, Integer> licenseId;
    public static volatile SingularAttribute<Licenses, Short> birthYear;
    public static volatile SingularAttribute<Licenses, String> middlename;
    public static volatile SingularAttribute<Licenses, Date> firstLicense;
    public static volatile SingularAttribute<Licenses, String> lastname;
    public static volatile SingularAttribute<Licenses, String> firstname;

}