
package restoran;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import restoran.exceptions.NonexistentEntityException;


public class StoRezervacijaJpaController implements Serializable {

    public StoRezervacijaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StoRezervacija stoRezervacija) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rezervacija rezervacija = stoRezervacija.getRezervacija();
            if (rezervacija != null) {
                rezervacija = em.getReference(rezervacija.getClass(), rezervacija.getIdRez());
                stoRezervacija.setRezervacija(rezervacija);
            }
            Sto sto = stoRezervacija.getSto();
            if (sto != null) {
                sto = em.getReference(sto.getClass(), sto.getIdSto());
                stoRezervacija.setSto(sto);
            }
            em.persist(stoRezervacija);
            if (rezervacija != null) {
                rezervacija.getStoRezervacijaCollection().add(stoRezervacija);
                rezervacija = em.merge(rezervacija);
            }
            if (sto != null) {
                sto.getStoRezervacijaCollection().add(stoRezervacija);
                sto = em.merge(sto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StoRezervacija stoRezervacija) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StoRezervacija persistentStoRezervacija = em.find(StoRezervacija.class, stoRezervacija.getIdStoRezervacija());
            Rezervacija rezervacijaOld = persistentStoRezervacija.getRezervacija();
            Rezervacija rezervacijaNew = stoRezervacija.getRezervacija();
            Sto stoOld = persistentStoRezervacija.getSto();
            Sto stoNew = stoRezervacija.getSto();
            if (rezervacijaNew != null) {
                rezervacijaNew = em.getReference(rezervacijaNew.getClass(), rezervacijaNew.getIdRez());
                stoRezervacija.setRezervacija(rezervacijaNew);
            }
            if (stoNew != null) {
                stoNew = em.getReference(stoNew.getClass(), stoNew.getIdSto());
                stoRezervacija.setSto(stoNew);
            }
            stoRezervacija = em.merge(stoRezervacija);
            if (rezervacijaOld != null && !rezervacijaOld.equals(rezervacijaNew)) {
                rezervacijaOld.getStoRezervacijaCollection().remove(stoRezervacija);
                rezervacijaOld = em.merge(rezervacijaOld);
            }
            if (rezervacijaNew != null && !rezervacijaNew.equals(rezervacijaOld)) {
                rezervacijaNew.getStoRezervacijaCollection().add(stoRezervacija);
                rezervacijaNew = em.merge(rezervacijaNew);
            }
            if (stoOld != null && !stoOld.equals(stoNew)) {
                stoOld.getStoRezervacijaCollection().remove(stoRezervacija);
                stoOld = em.merge(stoOld);
            }
            if (stoNew != null && !stoNew.equals(stoOld)) {
                stoNew.getStoRezervacijaCollection().add(stoRezervacija);
                stoNew = em.merge(stoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = stoRezervacija.getIdStoRezervacija();
                if (findStoRezervacija(id) == null) {
                    throw new NonexistentEntityException("The stoRezervacija with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StoRezervacija stoRezervacija;
            try {
                stoRezervacija = em.getReference(StoRezervacija.class, id);
                stoRezervacija.getIdStoRezervacija();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stoRezervacija with id " + id + " no longer exists.", enfe);
            }
            Rezervacija rezervacija = stoRezervacija.getRezervacija();
            if (rezervacija != null) {
                rezervacija.getStoRezervacijaCollection().remove(stoRezervacija);
                rezervacija = em.merge(rezervacija);
            }
            Sto sto = stoRezervacija.getSto();
            if (sto != null) {
                sto.getStoRezervacijaCollection().remove(stoRezervacija);
                sto = em.merge(sto);
            }
            em.remove(stoRezervacija);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StoRezervacija> findStoRezervacijaEntities() {
        return findStoRezervacijaEntities(true, -1, -1);
    }

    public List<StoRezervacija> findStoRezervacijaEntities(int maxResults, int firstResult) {
        return findStoRezervacijaEntities(false, maxResults, firstResult);
    }

    private List<StoRezervacija> findStoRezervacijaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StoRezervacija.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public StoRezervacija findStoRezervacija(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StoRezervacija.class, id);
        } finally {
            em.close();
        }
    }

    public int getStoRezervacijaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StoRezervacija> rt = cq.from(StoRezervacija.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
