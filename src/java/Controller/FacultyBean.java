package Controller;

import Dao.FacultyDAO;
import Entities.Faculty;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "facultyBean")
@ViewScoped
public class FacultyBean implements Serializable {

    private Faculty faculty;
    @EJB
    private FacultyDAO dao;

    public FacultyBean() {
    }

    public FacultyBean(Faculty faculty, FacultyDAO dao) {
        this.faculty = faculty;
        this.dao = dao;
    }

    public void create() {
        this.dao.create(faculty);
        this.faculty = new Faculty();
    }

    public List<Faculty> getRead() {
        return this.dao.findAll();
    }

    public void updateForm(Faculty c) {
        this.faculty = c;
    }

    public void update() {
        this.dao.edit(faculty);
        this.faculty = new Faculty();

    }

    public void delete(Faculty c) {
        this.dao.remove(c);

    }

    public Long find(Long id) {
        if (this.dao.find(id) != null) {
            return id;
        } else {
            return null;
        }
    }

    public Faculty getFaculty() {
        if (this.faculty == null) {
            return this.faculty = new Faculty();
        }
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

}
