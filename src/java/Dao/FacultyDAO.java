package Dao;

import Entities.Faculty;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class FacultyDAO extends AbstractDAO<Faculty> {

    @PersistenceContext(unitName = "sPU")
    private EntityManager em;

    public FacultyDAO() {
        super(Faculty.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Long findID(Object id) {
        Query query = em.createQuery("select f from Faculty f where f.id = :id");
        query.setParameter("id", id);
        List<Faculty> result = query.getResultList();

        if (result != null && result.size() > 0) {
            return result.get(0).getId();
        }
        return null;
    }
}
