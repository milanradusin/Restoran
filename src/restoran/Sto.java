
package restoran;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "sto")
@NamedQueries({
    @NamedQuery(name = "Sto.findAll", query = "SELECT s FROM Sto s")
    , @NamedQuery(name = "Sto.findByIdSto", query = "SELECT s FROM Sto s WHERE s.idSto = :idSto")
    , @NamedQuery(name = "Sto.findByBrojStola", query = "SELECT s FROM Sto s WHERE s.brojStola = :brojStola")
    , @NamedQuery(name = "Sto.findByMesta", query = "SELECT s FROM Sto s WHERE s.mesta = :mesta")
    , @NamedQuery(name = "Sto.findByX", query = "SELECT s FROM Sto s WHERE s.x = :x")
    , @NamedQuery(name = "Sto.findByY", query = "SELECT s FROM Sto s WHERE s.y = :y")
    , @NamedQuery(name = "Sto.findByIsActive", query = "SELECT s FROM Sto s WHERE s.isActive = :isActive")})
public class Sto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sto")
    private Integer idSto;
    @Column(name = "broj_stola")
    private Integer brojStola;
    @Column(name = "mesta")
    private Integer mesta;
    @Column(name = "x")
    private Integer x;
    @Column(name = "y")
    private Integer y;
    @Column(name = "is_active")
    private Boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sto")
    private Collection<Rezervacija> rezervacijaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sto")
    private Collection<StoRezervacija> stoRezervacijaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sto")
    private Collection<Stanje> stanjeCollection;

    public Sto() {
    }

    public Sto(Integer idSto) {
        this.idSto = idSto;
    }

    public Integer getIdSto() {
        return idSto;
    }

    public void setIdSto(Integer idSto) {
        this.idSto = idSto;
    }

    public Integer getBrojStola() {
        return brojStola;
    }

    public void setBrojStola(Integer brojStola) {
        this.brojStola = brojStola;
    }

    public Integer getMesta() {
        return mesta;
    }

    public void setMesta(Integer mesta) {
        this.mesta = mesta;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Collection<Rezervacija> getRezervacijaCollection() {
        return rezervacijaCollection;
    }

    public void setRezervacijaCollection(Collection<Rezervacija> rezervacijaCollection) {
        this.rezervacijaCollection = rezervacijaCollection;
    }

    public Collection<StoRezervacija> getStoRezervacijaCollection() {
        return stoRezervacijaCollection;
    }

    public void setStoRezervacijaCollection(Collection<StoRezervacija> stoRezervacijaCollection) {
        this.stoRezervacijaCollection = stoRezervacijaCollection;
    }

    public Collection<Stanje> getStanjeCollection() {
        return stanjeCollection;
    }

    public void setStanjeCollection(Collection<Stanje> stanjeCollection) {
        this.stanjeCollection = stanjeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSto != null ? idSto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sto)) {
            return false;
        }
        Sto other = (Sto) object;
        if ((this.idSto == null && other.idSto != null) || (this.idSto != null && !this.idSto.equals(other.idSto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  idSto +"";
    }

}
