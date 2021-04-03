package Dao;

import Entities.Academician;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AcademicianDAO extends AbstractDAO<Academician> {

    @PersistenceContext(unitName = "sPU")
    private EntityManager em;

    public AcademicianDAO() {
        super(Academician.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Academician> countStaff() {
        Query query = em.createQuery("select COUNT(a.staff) from Academician a ");
        List<Academician> result = query.getResultList();
        if (result != null && result.size() > 0) {
            return result;
        }
        return null;
    }

}
