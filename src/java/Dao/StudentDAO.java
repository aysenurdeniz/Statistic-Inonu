package Dao;

import Entities.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class StudentDAO extends AbstractDAO<Student> {

    @PersistenceContext(unitName = "sPU")
    private EntityManager em;

    public StudentDAO() {
        super(Student.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Student> countStandardDegree() {
        Query query = em.createQuery("select COUNT(s.standardDegree) from Student s ");
        List<Student> result = query.getResultList();
        if (result != null && result.size() > 0) {
            return result;
        }
        return null;
    }

    public List<Student> countHighDegree() {
        Query query = em.createQuery("select COUNT(s.highDegree) from Student s ");
        List<Student> result = query.getResultList();
        if (result != null && result.size() > 0) {
            return result;
        }
        return null;
    }
    
    public List<Student> countStatus() {
          Query query = em.createQuery("select COUNT(s.status) from Student s ");
          List<Student> result = query.getResultList();
       if (result != null && result.size() > 0) {
            return result;
        }
        return null;
    }
    
    
    public List<Student> countBachelor() {
          Query query = em.createQuery("select COUNT(o.standardDegree) from Student o where o.standardDegree LIKE 'Bachelor'");
          List<Student> result = query.getResultList();
       if (result != null && result.size() > 0) {
            return result;
        }
        return null;
    }
    
    public List<Student> countDoctora() {
          Query query = em.createQuery("select COUNT(o.highDegree) from Student o where o.highDegree LIKE 'phD'");
          List<Student> result = query.getResultList();
       if (result != null && result.size() > 0) {
            return result;
        }
        return null;
    }
    
      public List<Student> countMaster() {
          Query query = em.createQuery("select COUNT(o.highDegree) from Student o where o.highDegree LIKE 'Master'");
          List<Student> result = query.getResultList();
       if (result != null && result.size() > 0) {
            return result;
        }
        return null;
    }
    
}
