package Dao;

import Entities.Scholarship;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ScholarshipDAO extends AbstractDAO<Scholarship> {

    @PersistenceContext(unitName = "sPU")
    private EntityManager em;

    public ScholarshipDAO() {
        super(Scholarship.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
