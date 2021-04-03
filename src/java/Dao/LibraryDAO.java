package Dao;

import Entities.Library;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LibraryDAO extends AbstractDAO<Library> {

    @PersistenceContext(unitName = "sPU")
    private EntityManager em;

    public LibraryDAO() {
        super(Library.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
