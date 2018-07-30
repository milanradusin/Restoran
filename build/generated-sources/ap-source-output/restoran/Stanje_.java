package restoran;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restoran.Sto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-30T20:17:46")
@StaticMetamodel(Stanje.class)
public class Stanje_ { 

    public static volatile SingularAttribute<Stanje, Date> zauzetKraj;
    public static volatile SingularAttribute<Stanje, Integer> idStanje;
    public static volatile SingularAttribute<Stanje, Date> zauzetPocetak;
    public static volatile SingularAttribute<Stanje, Sto> sto;

}