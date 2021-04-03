package Dao;

import Entities.Socialservice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SocialserviceDAO extends AbstractDAO<Socialservice> {

    @PersistenceContext(unitName = "sPU")
    private EntityManager em;

    public SocialserviceDAO() {
        super(Socialservice.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
