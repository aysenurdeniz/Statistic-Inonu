package Dao;

import Entities.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EmployeeDAO extends AbstractDAO<Employee> {

    @PersistenceContext(unitName = "sPU")
    private EntityManager em;

    public EmployeeDAO() {
        super(Employee.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Employee login(String username, String password) {
        Query query = em.createQuery("select e from Employee e where e.username = :username and e.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);

        List<Employee> result = query.getResultList();

        if (result != null && result.size() > 0) {
            return result.get(0); 
        }
        return null;
    }
}
