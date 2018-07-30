package restoran;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restoran.Rezervacija;
import restoran.Stanje;
import restoran.StoRezervacija;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-30T20:17:46")
@StaticMetamodel(Sto.class)
public class Sto_ { 

    public static volatile SingularAttribute<Sto, Integer> idSto;
    public static volatile CollectionAttribute<Sto, Rezervacija> rezervacijaCollection;
    public static volatile SingularAttribute<Sto, Integer> mesta;
    public static volatile SingularAttribute<Sto, Integer> x;
    public static volatile SingularAttribute<Sto, Integer> y;
    public static volatile CollectionAttribute<Sto, StoRezervacija> stoRezervacijaCollection;
    public static volatile SingularAttribute<Sto, Boolean> isActive;
    public static volatile SingularAttribute<Sto, Integer> brojStola;
    public static volatile CollectionAttribute<Sto, Stanje> stanjeCollection;

}