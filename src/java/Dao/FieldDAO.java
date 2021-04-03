package Dao;

import Entities.Field;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class FieldDAO extends AbstractDAO<Field> {

    @PersistenceContext(unitName = "sPU")
    private EntityManager em;

    public FieldDAO() {
        super(Field.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Long findID(Object id) {
        Query query = em.createQuery("select f from Field f where f.id = :id");
        query.setParameter("id", id);
        List<Field> result = query.getResultList();

        if (result != null && result.size() > 0) {
            return result.get(0).getId();
        }
        return null;
    }
}
