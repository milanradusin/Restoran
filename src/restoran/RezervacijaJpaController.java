
package restoran;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import restoran.exceptions.IllegalOrphanException;
import restoran.exceptions.NonexistentEntityException;


public class RezervacijaJpaController implements Serializable {

    public RezervacijaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rezervacija rezervacija) {
        if (rezervacija.getStoRezervacijaCollection() == null) {
            rezervacija.setStoRezervacijaCollection(new ArrayList<StoRezervacija>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sto sto = rezervacija.getSto();
            if (sto != null) {
                sto = em.getReference(sto.getClass(), sto.getIdSto());
                rezervacija.setSto(sto);
            }
            Collection<StoRezervacija> attachedStoRezervacijaCollection = new ArrayList<StoRezervacija>();
            for (StoRezervacija stoRezervacijaCollectionStoRezervacijaToAttach : rezervacija.getStoRezervacijaCollection()) {
                stoRezervacijaCollectionStoRezervacijaToAttach = em.getReference(stoRezervacijaCollectionStoRezervacijaToAttach.getClass(), stoRezervacijaCollectionStoRezervacijaToAttach.getIdStoRezervacija());
                attachedStoRezervacijaCollection.add(stoRezervacijaCollectionStoRezervacijaToAttach);
            }
            rezervacija.setStoRezervacijaCollection(attachedStoRezervacijaCollection);
            em.persist(rezervacija);
            if (sto != null) {
                sto.getRezervacijaCollection().add(rezervacija);
                sto = em.merge(sto);
            }
            for (StoRezervacija stoRezervacijaCollectionStoRezervacija : rezervacija.getStoRezervacijaCollection()) {
                Rezervacija oldRezervacijaOfStoRezervacijaCollectionStoRezervacija = stoRezervacijaCollectionStoRezervacija.getRezervacija();
                stoRezervacijaCollectionStoRezervacija.setRezervacija(rezervacija);
                stoRezervacijaCollectionStoRezervacija = em.merge(stoRezervacijaCollectionStoRezervacija);
                if (oldRezervacijaOfStoRezervacijaCollectionStoRezervacija != null) {
                    oldRezervacijaOfStoRezervacijaCollectionStoRezervacija.getStoRezervacijaCollection().remove(stoRezervacijaCollectionStoRezervacija);
                    oldRezervacijaOfStoRezervacijaCollectionStoRezervacija = em.merge(oldRezervacijaOfStoRezervacijaCollectionStoRezervacija);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rezervacija rezervacija) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rezervacija persistentRezervacija = em.find(Rezervacija.class, rezervacija.getIdRez());
            Sto stoOld = persistentRezervacija.getSto();
            Sto stoNew = rezervacija.getSto();
            Collection<StoRezervacija> stoRezervacijaCollectionOld = persistentRezervacija.getStoRezervacijaCollection();
            Collection<StoRezervacija> stoRezervacijaCollectionNew = rezervacija.getStoRezervacijaCollection();
            List<String> illegalOrphanMessages = null;
            for (StoRezervacija stoRezervacijaCollectionOldStoRezervacija : stoRezervacijaCollectionOld) {
                if (!stoRezervacijaCollectionNew.contains(stoRezervacijaCollectionOldStoRezervacija)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain StoRezervacija " + stoRezervacijaCollectionOldStoRezervacija + " since its rezervacija field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (stoNew != null) {
                stoNew = em.getReference(stoNew.getClass(), stoNew.getIdSto());
                rezervacija.setSto(stoNew);
            }
            Collection<StoRezervacija> attachedStoRezervacijaCollectionNew = new ArrayList<StoRezervacija>();
            for (StoRezervacija stoRezervacijaCollectionNewStoRezervacijaToAttach : stoRezervacijaCollectionNew) {
                stoRezervacijaCollectionNewStoRezervacijaToAttach = em.getReference(stoRezervacijaCollectionNewStoRezervacijaToAttach.getClass(), stoRezervacijaCollectionNewStoRezervacijaToAttach.getIdStoRezervacija());
                attachedStoRezervacijaCollectionNew.add(stoRezervacijaCollectionNewStoRezervacijaToAttach);
            }
            stoRezervacijaCollectionNew = attachedStoRezervacijaCollectionNew;
            rezervacija.setStoRezervacijaCollection(stoRezervacijaCollectionNew);
            rezervacija = em.merge(rezervacija);
            if (stoOld != null && !stoOld.equals(stoNew)) {
                stoOld.getRezervacijaCollection().remove(rezervacija);
                stoOld = em.merge(stoOld);
            }
            if (stoNew != null && !stoNew.equals(stoOld)) {
                stoNew.getRezervacijaCollection().add(rezervacija);
                stoNew = em.merge(stoNew);
            }
            for (StoRezervacija stoRezervacijaCollectionNewStoRezervacija : stoRezervacijaCollectionNew) {
                if (!stoRezervacijaCollectionOld.contains(stoRezervacijaCollectionNewStoRezervacija)) {
                    Rezervacija oldRezervacijaOfStoRezervacijaCollectionNewStoRezervacija = stoRezervacijaCollectionNewStoRezervacija.getRezervacija();
                    stoRezervacijaCollectionNewStoRezervacija.setRezervacija(rezervacija);
                    stoRezervacijaCollectionNewStoRezervacija = em.merge(stoRezervacijaCollectionNewStoRezervacija);
                    if (oldRezervacijaOfStoRezervacijaCollectionNewStoRezervacija != null && !oldRezervacijaOfStoRezervacijaCollectionNewStoRezervacija.equals(rezervacija)) {
                        oldRezervacijaOfStoRezervacijaCollectionNewStoRezervacija.getStoRezervacijaCollection().remove(stoRezervacijaCollectionNewStoRezervacija);
                        oldRezervacijaOfStoRezervacijaCollectionNewStoRezervacija = em.merge(oldRezervacijaOfStoRezervacijaCollectionNewStoRezervacija);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rezervacija.getIdRez();
                if (findRezervacija(id) == null) {
                    throw new NonexistentEntityException("The rezervacija with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rezervacija rezervacija;
            try {
                rezervacija = em.getReference(Rezervacija.class, id);
                rezervacija.getIdRez();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rezervacija with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<StoRezervacija> stoRezervacijaCollectionOrphanCheck = rezervacija.getStoRezervacijaCollection();
            for (StoRezervacija stoRezervacijaCollectionOrphanCheckStoRezervacija : stoRezervacijaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Rezervacija (" + rezervacija + ") cannot be destroyed since the StoRezervacija " + stoRezervacijaCollectionOrphanCheckStoRezervacija + " in its stoRezervacijaCollection field has a non-nullable rezervacija field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Sto sto = rezervacija.getSto();
            if (sto != null) {
                sto.getRezervacijaCollection().remove(rezervacija);
                sto = em.merge(sto);
            }
            em.remove(rezervacija);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rezervacija> findRezervacijaEntities() {
        return findRezervacijaEntities(true, -1, -1);
    }

    public List<Rezervacija> findRezervacijaEntities(int maxResults, int firstResult) {
        return findRezervacijaEntities(false, maxResults, firstResult);
    }

    private List<Rezervacija> findRezervacijaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rezervacija.class));
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

    public Rezervacija findRezervacija(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rezervacija.class, id);
        } finally {
            em.close();
        }
    }

    public int getRezervacijaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rezervacija> rt = cq.from(Rezervacija.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
