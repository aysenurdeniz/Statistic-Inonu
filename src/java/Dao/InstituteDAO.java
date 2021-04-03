package Dao;

import Entities.Institute;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InstituteDAO extends AbstractDAO<Institute> {

    @PersistenceContext(unitName = "sPU")
    private EntityManager em;

    public InstituteDAO() {
        super(Institute.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
