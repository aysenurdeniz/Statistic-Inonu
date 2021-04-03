package Controller;

import Dao.ScholarshipDAO;
import Entities.Scholarship;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "scholarshipBean")
@ViewScoped
public class ScholarshipBean implements Serializable {

    private Scholarship scholarship;
    @EJB
    private ScholarshipDAO dao;

    public ScholarshipBean() {
    }

    public ScholarshipBean(Scholarship scholarship, ScholarshipDAO dao) {
        this.scholarship = scholarship;
        this.dao = dao;
    }

    public void create() {
        this.dao.create(scholarship);
        this.scholarship = new Scholarship();
    }

    public List<Scholarship> getRead() {
        return this.dao.findAll();
    }

    public void updateForm(Scholarship c) {
        this.scholarship = c;
    }

    public void update() {
        this.dao.edit(scholarship);
        this.scholarship = new Scholarship();
    }

    public void delete(Scholarship c) {
        this.dao.remove(c);

    }

    public Scholarship getScholarship() {
        if (this.scholarship == null) {
            return this.scholarship = new Scholarship();
        }
        return scholarship;
    }

    public void setScholarship(Scholarship scholarship) {
        this.scholarship = scholarship;
    }

}
