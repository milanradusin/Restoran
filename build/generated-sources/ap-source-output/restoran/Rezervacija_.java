package restoran;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restoran.Sto;
import restoran.StoRezervacija;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-30T20:17:44")
@StaticMetamodel(Rezervacija.class)
public class Rezervacija_ { 

    public static volatile SingularAttribute<Rezervacija, String> ime;
    public static volatile SingularAttribute<Rezervacija, Date> datum;
    public static volatile SingularAttribute<Rezervacija, Integer> brojOsoba;
    public static volatile SingularAttribute<Rezervacija, String> telefon;
    public static volatile SingularAttribute<Rezervacija, Integer> idRez;
    public static volatile CollectionAttribute<Rezervacija, StoRezervacija> stoRezervacijaCollection;
    public static volatile SingularAttribute<Rezervacija, Boolean> isactiveR;
    public static volatile SingularAttribute<Rezervacija, Sto> sto;

}