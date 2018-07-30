
package restoran;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "stanje")
@NamedQueries({
    @NamedQuery(name = "Stanje.findAll", query = "SELECT s FROM Stanje s")
    , @NamedQuery(name = "Stanje.findByIdStanje", query = "SELECT s FROM Stanje s WHERE s.idStanje = :idStanje")
    , @NamedQuery(name = "Stanje.findByZauzetPocetak", query = "SELECT s FROM Stanje s WHERE s.zauzetPocetak = :zauzetPocetak")
    , @NamedQuery(name = "Stanje.findByZauzetKraj", query = "SELECT s FROM Stanje s WHERE s.zauzetKraj = :zauzetKraj")})
public class Stanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_stanje")
    private Integer idStanje;
    @Column(name = "zauzet_pocetak")
    @Temporal(TemporalType.TIMESTAMP)
    private Date zauzetPocetak;
    @Column(name = "zauzet_kraj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date zauzetKraj;
    @JoinColumn(name = "sto", referencedColumnName = "id_sto")
    @ManyToOne(optional = false)
    private Sto sto;

    public Stanje() {
    }

    public Stanje(Integer idStanje) {
        this.idStanje = idStanje;
    }

    public Integer getIdStanje() {
        return idStanje;
    }

    public void setIdStanje(Integer idStanje) {
        this.idStanje = idStanje;
    }

    public Date getZauzetPocetak() {
        return zauzetPocetak;
    }

    public void setZauzetPocetak(Date zauzetPocetak) {
        this.zauzetPocetak = zauzetPocetak;
    }

    public Date getZauzetKraj() {
        return zauzetKraj;
    }

    public void setZauzetKraj(Date zauzetKraj) {
        this.zauzetKraj = zauzetKraj;
    }

    public Sto getSto() {
        return sto;
    }

    public void setSto(Sto sto) {
        this.sto = sto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStanje != null ? idStanje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stanje)) {
            return false;
        }
        Stanje other = (Stanje) object;
        if ((this.idStanje == null && other.idStanje != null) || (this.idStanje != null && !this.idStanje.equals(other.idStanje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restoran.Stanje[ idStanje=" + idStanje + " ]";
    }

}
