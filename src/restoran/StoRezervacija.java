
package restoran;

import java.io.Serializable;
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


@Entity
@Table(name = "sto_rezervacija")
@NamedQueries({
    @NamedQuery(name = "StoRezervacija.findAll", query = "SELECT s FROM StoRezervacija s")
    , @NamedQuery(name = "StoRezervacija.findByIdStoRezervacija", query = "SELECT s FROM StoRezervacija s WHERE s.idStoRezervacija = :idStoRezervacija")})
public class StoRezervacija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sto_rezervacija")
    private Integer idStoRezervacija;
    @JoinColumn(name = "rezervacija", referencedColumnName = "id_rez")
    @ManyToOne(optional = false)
    private Rezervacija rezervacija;
    @JoinColumn(name = "sto", referencedColumnName = "id_sto")
    @ManyToOne(optional = false)
    private Sto sto;

    public StoRezervacija() {
    }

    public StoRezervacija(Integer idStoRezervacija) {
        this.idStoRezervacija = idStoRezervacija;
    }

    public Integer getIdStoRezervacija() {
        return idStoRezervacija;
    }

    public void setIdStoRezervacija(Integer idStoRezervacija) {
        this.idStoRezervacija = idStoRezervacija;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
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
        hash += (idStoRezervacija != null ? idStoRezervacija.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoRezervacija)) {
            return false;
        }
        StoRezervacija other = (StoRezervacija) object;
        if ((this.idStoRezervacija == null && other.idStoRezervacija != null) || (this.idStoRezervacija != null && !this.idStoRezervacija.equals(other.idStoRezervacija))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restoran.StoRezervacija[ idStoRezervacija=" + idStoRezervacija + " ]";
    }

}
