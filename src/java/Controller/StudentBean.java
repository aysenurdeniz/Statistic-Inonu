package Controller;

import Dao.FieldDAO;
import Dao.StudentDAO;
import Entities.Field;
import Entities.Student;
import Enums.Degree;
import Enums.Gender;
import Enums.HighDegree;
import Enums.StandardDegree;
import Enums.Status;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "studentBean")
@ViewScoped
public class StudentBean implements Serializable {

    private Student student;
    @EJB
    private StudentDAO dao;

    @EJB
    private FieldDAO fdao;

    public StudentBean() {
    }

    public StudentBean(Student student, StudentDAO dao, FieldDAO fdao) {
        this.student = student;
        this.dao = dao;
        this.fdao = fdao;
    }

    public void create() {
        this.dao.create(student);
        this.student = new Student();
    }

    public List<Student> getRead() {
        return this.dao.findAll();
    }

    public List<Field> getAll() {
        return this.fdao.findAll();
    }

    public void updateForm(Student c) {
        this.student = c;
    }

    public void update() {
        this.dao.edit(student);
        this.student = new Student();
    }

    public void delete(Student c) {
        this.dao.remove(c);
    }

    public Gender[] getGender() {
        return Gender.values();
    }

    public Status[] getStatus() {
        return Status.values();
    }

    public Degree[] getDegree() {
        return Degree.values();
    }

    public StandardDegree[] getStandardDegree() {
        return StandardDegree.values();
    }

    public HighDegree[] getHighDegree() {
        return HighDegree.values();
    }

    public List<Student> standardDegreeCount() {
        return this.dao.countStandardDegree();
    }

    public List<Student> highDegreeCount() {
        return this.dao.countHighDegree();
    }

    public Student getStudent() {
        if (this.student == null) {
            return this.student = new Student();
        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
       public List<Student> statusCount() {
        return this.dao.countStatus();
    }

    public List<Student> bachelorCount() {
        return this.dao.countBachelor();
    }

    public List<Student> highDCount() {
        return this.dao.countHighDegree();
    }

    public List<Student> doctoraCount() {
        return this.dao.countDoctora();
    }

    public List<Student> masterCount() {
        return this.dao.countMaster();
    }

}
