package Dao;

import Entities.Physicalservice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PhysicalserviceDAO extends AbstractDAO<Physicalservice> {

    @PersistenceContext(unitName = "sPU")
    private EntityManager em;

    public PhysicalserviceDAO() {
        super(Physicalservice.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
