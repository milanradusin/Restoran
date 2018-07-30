
package restoran;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "rezervacija")
@NamedQueries({
    @NamedQuery(name = "Rezervacija.findAll", query = "SELECT r FROM Rezervacija r")
    , @NamedQuery(name = "Rezervacija.findByIdRez", query = "SELECT r FROM Rezervacija r WHERE r.idRez = :idRez")
    , @NamedQuery(name = "Rezervacija.findByIme", query = "SELECT r FROM Rezervacija r WHERE r.ime = :ime")
    , @NamedQuery(name = "Rezervacija.findByTelefon", query = "SELECT r FROM Rezervacija r WHERE r.telefon = :telefon")
    , @NamedQuery(name = "Rezervacija.findByBrojOsoba", query = "SELECT r FROM Rezervacija r WHERE r.brojOsoba = :brojOsoba")
    , @NamedQuery(name = "Rezervacija.findByDatum", query = "SELECT r FROM Rezervacija r WHERE r.datum = :datum")
    , @NamedQuery(name = "Rezervacija.findByIsactiveR", query = "SELECT r FROM Rezervacija r WHERE r.isactiveR = :isactiveR")})
public class Rezervacija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rez")
    private Integer idRez;
    @Column(name = "ime")
    private String ime;
    @Column(name = "telefon")
    private String telefon;
    @Column(name = "broj_osoba")
    private Integer brojOsoba;
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Column(name = "is_active_R")
    private Boolean isactiveR;
    @JoinColumn(name = "sto", referencedColumnName = "id_sto")
    @ManyToOne(optional = false)
    private Sto sto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rezervacija")
    private Collection<StoRezervacija> stoRezervacijaCollection;

    public Rezervacija() {
    }

    public Rezervacija(Integer idRez) {
        this.idRez = idRez;
    }

    public Integer getIdRez() {
        return idRez;
    }

    public void setIdRez(Integer idRez) {
        this.idRez = idRez;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Integer getBrojOsoba() {
        return brojOsoba;
    }

    public void setBrojOsoba(Integer brojOsoba) {
        this.brojOsoba = brojOsoba;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Boolean getIsactiveR() {
        return isactiveR;
    }

    public void setIsactiveR(Boolean isactiveR) {
        this.isactiveR = isactiveR;
    }

    public Sto getSto() {
        return sto;
    }

    public void setSto(Sto sto) {
        this.sto = sto;
    }

    public Collection<StoRezervacija> getStoRezervacijaCollection() {
        return stoRezervacijaCollection;
    }

    public void setStoRezervacijaCollection(Collection<StoRezervacija> stoRezervacijaCollection) {
        this.stoRezervacijaCollection = stoRezervacijaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRez != null ? idRez.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rezervacija)) {
            return false;
        }
        Rezervacija other = (Rezervacija) object;
        if ((this.idRez == null && other.idRez != null) || (this.idRez != null && !this.idRez.equals(other.idRez))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restoran.Rezervacija[ idRez=" + idRez + " ]";
    }

}
