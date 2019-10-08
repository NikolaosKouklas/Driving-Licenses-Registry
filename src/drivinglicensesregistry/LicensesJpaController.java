/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivinglicensesregistry;

import drivinglicensesregistry.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Nikolaos
 */
public class LicensesJpaController implements Serializable {

    public LicensesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Licenses licenses) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(licenses);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Licenses licenses) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            licenses = em.merge(licenses);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = licenses.getId();
                if (findLicenses(id) == null) {
                    throw new NonexistentEntityException("The licenses with id " + id + " no longer exists.");
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
            Licenses licenses;
            try {
                licenses = em.getReference(Licenses.class, id);
                licenses.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The licenses with id " + id + " no longer exists.", enfe);
            }
            em.remove(licenses);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Licenses> findLicensesEntities() {
        return findLicensesEntities(true, -1, -1);
    }

    public List<Licenses> findLicensesEntities(int maxResults, int firstResult) {
        return findLicensesEntities(false, maxResults, firstResult);
    }

    private List<Licenses> findLicensesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Licenses.class));
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

    public Licenses findLicenses(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Licenses.class, id);
        } finally {
            em.close();
        }
    }

    public int getLicensesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Licenses> rt = cq.from(Licenses.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Number) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /******** My functions ********/
    public List<Licenses> getLicensesByLastname(String searchBox) {
        
        EntityManager em = getEntityManager();
        try {
            Query q1 = em.createQuery("SELECT l FROM Licenses l WHERE l.lastname LIKE CONCAT(UPPER(:lastname),'%') ORDER BY l.lastname");
            q1.setParameter("lastname", searchBox);
            return q1.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Licenses> getLicensesByLicenseIdWithRecordIdException(int licenseId, int recordId) {
        
        EntityManager em = getEntityManager();
        try {
            Query q1 = em.createQuery("SELECT l FROM Licenses l WHERE l.licenseId = :licenseId AND l.id <> :recordId");
            q1.setParameter("licenseId", licenseId);
            q1.setParameter("recordId", recordId);
            return q1.getResultList();
        } finally {
            em.close();
        }
    }
    
    public Licenses getLicenseByLicenseId(int licenseId) {
        
        EntityManager em = getEntityManager();
        try {
            Query q1 = em.createQuery("SELECT l FROM Licenses l WHERE l.licenseId = :licenseId");
            q1.setParameter("licenseId", licenseId);
            return (Licenses) q1.getSingleResult();
        }
        catch (Exception e) {
            return null;
        }
        finally {
            em.close();
        }
    }
}
