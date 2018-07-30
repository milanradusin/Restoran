
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


public class StanjeJpaController implements Serializable {

    public StanjeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Stanje stanje) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sto sto = stanje.getSto();
            if (sto != null) {
                sto = em.getReference(sto.getClass(), sto.getIdSto());
                stanje.setSto(sto);
            }
            em.persist(stanje);
            if (sto != null) {
                sto.getStanjeCollection().add(stanje);
                sto = em.merge(sto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Stanje stanje) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Stanje persistentStanje = em.find(Stanje.class, stanje.getIdStanje());
            Sto stoOld = persistentStanje.getSto();
            Sto stoNew = stanje.getSto();
            if (stoNew != null) {
                stoNew = em.getReference(stoNew.getClass(), stoNew.getIdSto());
                stanje.setSto(stoNew);
            }
            stanje = em.merge(stanje);
            if (stoOld != null && !stoOld.equals(stoNew)) {
                stoOld.getStanjeCollection().remove(stanje);
                stoOld = em.merge(stoOld);
            }
            if (stoNew != null && !stoNew.equals(stoOld)) {
                stoNew.getStanjeCollection().add(stanje);
                stoNew = em.merge(stoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = stanje.getIdStanje();
                if (findStanje(id) == null) {
                    throw new NonexistentEntityException("The stanje with id " + id + " no longer exists.");
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
            Stanje stanje;
            try {
                stanje = em.getReference(Stanje.class, id);
                stanje.getIdStanje();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The stanje with id " + id + " no longer exists.", enfe);
            }
            Sto sto = stanje.getSto();
            if (sto != null) {
                sto.getStanjeCollection().remove(stanje);
                sto = em.merge(sto);
            }
            em.remove(stanje);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Stanje> findStanjeEntities() {
        return findStanjeEntities(true, -1, -1);
    }

    public List<Stanje> findStanjeEntities(int maxResults, int firstResult) {
        return findStanjeEntities(false, maxResults, firstResult);
    }

    private List<Stanje> findStanjeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Stanje.class));
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

    public Stanje findStanje(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Stanje.class, id);
        } finally {
            em.close();
        }
    }

    public int getStanjeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Stanje> rt = cq.from(Stanje.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
