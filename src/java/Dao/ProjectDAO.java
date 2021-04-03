package Dao;

import Entities.Project;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProjectDAO extends AbstractDAO<Project> {

    @PersistenceContext(unitName = "sPU")
    private EntityManager em;

    public ProjectDAO() {
        super(Project.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
