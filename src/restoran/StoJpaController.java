
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


public class StoJpaController implements Serializable {

    public StoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sto sto) {
        if (sto.getRezervacijaCollection() == null) {
            sto.setRezervacijaCollection(new ArrayList<Rezervacija>());
        }
        if (sto.getStoRezervacijaCollection() == null) {
            sto.setStoRezervacijaCollection(new ArrayList<StoRezervacija>());
        }
        if (sto.getStanjeCollection() == null) {
            sto.setStanjeCollection(new ArrayList<Stanje>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Rezervacija> attachedRezervacijaCollection = new ArrayList<Rezervacija>();
            for (Rezervacija rezervacijaCollectionRezervacijaToAttach : sto.getRezervacijaCollection()) {
                rezervacijaCollectionRezervacijaToAttach = em.getReference(rezervacijaCollectionRezervacijaToAttach.getClass(), rezervacijaCollectionRezervacijaToAttach.getIdRez());
                attachedRezervacijaCollection.add(rezervacijaCollectionRezervacijaToAttach);
            }
            sto.setRezervacijaCollection(attachedRezervacijaCollection);
            Collection<StoRezervacija> attachedStoRezervacijaCollection = new ArrayList<StoRezervacija>();
            for (StoRezervacija stoRezervacijaCollectionStoRezervacijaToAttach : sto.getStoRezervacijaCollection()) {
                stoRezervacijaCollectionStoRezervacijaToAttach = em.getReference(stoRezervacijaCollectionStoRezervacijaToAttach.getClass(), stoRezervacijaCollectionStoRezervacijaToAttach.getIdStoRezervacija());
                attachedStoRezervacijaCollection.add(stoRezervacijaCollectionStoRezervacijaToAttach);
            }
            sto.setStoRezervacijaCollection(attachedStoRezervacijaCollection);
            Collection<Stanje> attachedStanjeCollection = new ArrayList<Stanje>();
            for (Stanje stanjeCollectionStanjeToAttach : sto.getStanjeCollection()) {
                stanjeCollectionStanjeToAttach = em.getReference(stanjeCollectionStanjeToAttach.getClass(), stanjeCollectionStanjeToAttach.getIdStanje());
                attachedStanjeCollection.add(stanjeCollectionStanjeToAttach);
            }
            sto.setStanjeCollection(attachedStanjeCollection);
            em.persist(sto);
            for (Rezervacija rezervacijaCollectionRezervacija : sto.getRezervacijaCollection()) {
                Sto oldStoOfRezervacijaCollectionRezervacija = rezervacijaCollectionRezervacija.getSto();
                rezervacijaCollectionRezervacija.setSto(sto);
                rezervacijaCollectionRezervacija = em.merge(rezervacijaCollectionRezervacija);
                if (oldStoOfRezervacijaCollectionRezervacija != null) {
                    oldStoOfRezervacijaCollectionRezervacija.getRezervacijaCollection().remove(rezervacijaCollectionRezervacija);
                    oldStoOfRezervacijaCollectionRezervacija = em.merge(oldStoOfRezervacijaCollectionRezervacija);
                }
            }
            for (StoRezervacija stoRezervacijaCollectionStoRezervacija : sto.getStoRezervacijaCollection()) {
                Sto oldStoOfStoRezervacijaCollectionStoRezervacija = stoRezervacijaCollectionStoRezervacija.getSto();
                stoRezervacijaCollectionStoRezervacija.setSto(sto);
                stoRezervacijaCollectionStoRezervacija = em.merge(stoRezervacijaCollectionStoRezervacija);
                if (oldStoOfStoRezervacijaCollectionStoRezervacija != null) {
                    oldStoOfStoRezervacijaCollectionStoRezervacija.getStoRezervacijaCollection().remove(stoRezervacijaCollectionStoRezervacija);
                    oldStoOfStoRezervacijaCollectionStoRezervacija = em.merge(oldStoOfStoRezervacijaCollectionStoRezervacija);
                }
            }
            for (Stanje stanjeCollectionStanje : sto.getStanjeCollection()) {
                Sto oldStoOfStanjeCollectionStanje = stanjeCollectionStanje.getSto();
                stanjeCollectionStanje.setSto(sto);
                stanjeCollectionStanje = em.merge(stanjeCollectionStanje);
                if (oldStoOfStanjeCollectionStanje != null) {
                    oldStoOfStanjeCollectionStanje.getStanjeCollection().remove(stanjeCollectionStanje);
                    oldStoOfStanjeCollectionStanje = em.merge(oldStoOfStanjeCollectionStanje);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sto sto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sto persistentSto = em.find(Sto.class, sto.getIdSto());
            Collection<Rezervacija> rezervacijaCollectionOld = persistentSto.getRezervacijaCollection();
            Collection<Rezervacija> rezervacijaCollectionNew = sto.getRezervacijaCollection();
            Collection<StoRezervacija> stoRezervacijaCollectionOld = persistentSto.getStoRezervacijaCollection();
            Collection<StoRezervacija> stoRezervacijaCollectionNew = sto.getStoRezervacijaCollection();
            Collection<Stanje> stanjeCollectionOld = persistentSto.getStanjeCollection();
            Collection<Stanje> stanjeCollectionNew = sto.getStanjeCollection();
            List<String> illegalOrphanMessages = null;
            for (Rezervacija rezervacijaCollectionOldRezervacija : rezervacijaCollectionOld) {
                if (!rezervacijaCollectionNew.contains(rezervacijaCollectionOldRezervacija)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Rezervacija " + rezervacijaCollectionOldRezervacija + " since its sto field is not nullable.");
                }
            }
            for (StoRezervacija stoRezervacijaCollectionOldStoRezervacija : stoRezervacijaCollectionOld) {
                if (!stoRezervacijaCollectionNew.contains(stoRezervacijaCollectionOldStoRezervacija)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain StoRezervacija " + stoRezervacijaCollectionOldStoRezervacija + " since its sto field is not nullable.");
                }
            }
            for (Stanje stanjeCollectionOldStanje : stanjeCollectionOld) {
                if (!stanjeCollectionNew.contains(stanjeCollectionOldStanje)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Stanje " + stanjeCollectionOldStanje + " since its sto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Rezervacija> attachedRezervacijaCollectionNew = new ArrayList<Rezervacija>();
            for (Rezervacija rezervacijaCollectionNewRezervacijaToAttach : rezervacijaCollectionNew) {
                rezervacijaCollectionNewRezervacijaToAttach = em.getReference(rezervacijaCollectionNewRezervacijaToAttach.getClass(), rezervacijaCollectionNewRezervacijaToAttach.getIdRez());
                attachedRezervacijaCollectionNew.add(rezervacijaCollectionNewRezervacijaToAttach);
            }
            rezervacijaCollectionNew = attachedRezervacijaCollectionNew;
            sto.setRezervacijaCollection(rezervacijaCollectionNew);
            Collection<StoRezervacija> attachedStoRezervacijaCollectionNew = new ArrayList<StoRezervacija>();
            for (StoRezervacija stoRezervacijaCollectionNewStoRezervacijaToAttach : stoRezervacijaCollectionNew) {
                stoRezervacijaCollectionNewStoRezervacijaToAttach = em.getReference(stoRezervacijaCollectionNewStoRezervacijaToAttach.getClass(), stoRezervacijaCollectionNewStoRezervacijaToAttach.getIdStoRezervacija());
                attachedStoRezervacijaCollectionNew.add(stoRezervacijaCollectionNewStoRezervacijaToAttach);
            }
            stoRezervacijaCollectionNew = attachedStoRezervacijaCollectionNew;
            sto.setStoRezervacijaCollection(stoRezervacijaCollectionNew);
            Collection<Stanje> attachedStanjeCollectionNew = new ArrayList<Stanje>();
            for (Stanje stanjeCollectionNewStanjeToAttach : stanjeCollectionNew) {
                stanjeCollectionNewStanjeToAttach = em.getReference(stanjeCollectionNewStanjeToAttach.getClass(), stanjeCollectionNewStanjeToAttach.getIdStanje());
                attachedStanjeCollectionNew.add(stanjeCollectionNewStanjeToAttach);
            }
            stanjeCollectionNew = attachedStanjeCollectionNew;
            sto.setStanjeCollection(stanjeCollectionNew);
            sto = em.merge(sto);
            for (Rezervacija rezervacijaCollectionNewRezervacija : rezervacijaCollectionNew) {
                if (!rezervacijaCollectionOld.contains(rezervacijaCollectionNewRezervacija)) {
                    Sto oldStoOfRezervacijaCollectionNewRezervacija = rezervacijaCollectionNewRezervacija.getSto();
                    rezervacijaCollectionNewRezervacija.setSto(sto);
                    rezervacijaCollectionNewRezervacija = em.merge(rezervacijaCollectionNewRezervacija);
                    if (oldStoOfRezervacijaCollectionNewRezervacija != null && !oldStoOfRezervacijaCollectionNewRezervacija.equals(sto)) {
                        oldStoOfRezervacijaCollectionNewRezervacija.getRezervacijaCollection().remove(rezervacijaCollectionNewRezervacija);
                        oldStoOfRezervacijaCollectionNewRezervacija = em.merge(oldStoOfRezervacijaCollectionNewRezervacija);
                    }
                }
            }
            for (StoRezervacija stoRezervacijaCollectionNewStoRezervacija : stoRezervacijaCollectionNew) {
                if (!stoRezervacijaCollectionOld.contains(stoRezervacijaCollectionNewStoRezervacija)) {
                    Sto oldStoOfStoRezervacijaCollectionNewStoRezervacija = stoRezervacijaCollectionNewStoRezervacija.getSto();
                    stoRezervacijaCollectionNewStoRezervacija.setSto(sto);
                    stoRezervacijaCollectionNewStoRezervacija = em.merge(stoRezervacijaCollectionNewStoRezervacija);
                    if (oldStoOfStoRezervacijaCollectionNewStoRezervacija != null && !oldStoOfStoRezervacijaCollectionNewStoRezervacija.equals(sto)) {
                        oldStoOfStoRezervacijaCollectionNewStoRezervacija.getStoRezervacijaCollection().remove(stoRezervacijaCollectionNewStoRezervacija);
                        oldStoOfStoRezervacijaCollectionNewStoRezervacija = em.merge(oldStoOfStoRezervacijaCollectionNewStoRezervacija);
                    }
                }
            }
            for (Stanje stanjeCollectionNewStanje : stanjeCollectionNew) {
                if (!stanjeCollectionOld.contains(stanjeCollectionNewStanje)) {
                    Sto oldStoOfStanjeCollectionNewStanje = stanjeCollectionNewStanje.getSto();
                    stanjeCollectionNewStanje.setSto(sto);
                    stanjeCollectionNewStanje = em.merge(stanjeCollectionNewStanje);
                    if (oldStoOfStanjeCollectionNewStanje != null && !oldStoOfStanjeCollectionNewStanje.equals(sto)) {
                        oldStoOfStanjeCollectionNewStanje.getStanjeCollection().remove(stanjeCollectionNewStanje);
                        oldStoOfStanjeCollectionNewStanje = em.merge(oldStoOfStanjeCollectionNewStanje);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sto.getIdSto();
                if (findSto(id) == null) {
                    throw new NonexistentEntityException("The sto with id " + id + " no longer exists.");
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
            Sto sto;
            try {
                sto = em.getReference(Sto.class, id);
                sto.getIdSto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Rezervacija> rezervacijaCollectionOrphanCheck = sto.getRezervacijaCollection();
            for (Rezervacija rezervacijaCollectionOrphanCheckRezervacija : rezervacijaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sto (" + sto + ") cannot be destroyed since the Rezervacija " + rezervacijaCollectionOrphanCheckRezervacija + " in its rezervacijaCollection field has a non-nullable sto field.");
            }
            Collection<StoRezervacija> stoRezervacijaCollectionOrphanCheck = sto.getStoRezervacijaCollection();
            for (StoRezervacija stoRezervacijaCollectionOrphanCheckStoRezervacija : stoRezervacijaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sto (" + sto + ") cannot be destroyed since the StoRezervacija " + stoRezervacijaCollectionOrphanCheckStoRezervacija + " in its stoRezervacijaCollection field has a non-nullable sto field.");
            }
            Collection<Stanje> stanjeCollectionOrphanCheck = sto.getStanjeCollection();
            for (Stanje stanjeCollectionOrphanCheckStanje : stanjeCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sto (" + sto + ") cannot be destroyed since the Stanje " + stanjeCollectionOrphanCheckStanje + " in its stanjeCollection field has a non-nullable sto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(sto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sto> findStoEntities() {
        return findStoEntities(true, -1, -1);
    }

    public List<Sto> findStoEntities(int maxResults, int firstResult) {
        return findStoEntities(false, maxResults, firstResult);
    }

    private List<Sto> findStoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sto.class));
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

    public Sto findSto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sto.class, id);
        } finally {
            em.close();
        }
    }

    public int getStoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sto> rt = cq.from(Sto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public Sto vratiSto(int idSto){
  EntityManager em = getEntityManager();
    Query q1 = em.createQuery("SELECT s FROM Sto s WHERE s.idSto = :id_sto");
    q1.setParameter("id_sto", idSto);
    return (Sto) q1.getSingleResult();
}

}
