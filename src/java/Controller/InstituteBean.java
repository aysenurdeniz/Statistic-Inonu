package Controller;

import Dao.InstituteDAO;
import Entities.Institute;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "instituteBean")
@ViewScoped
public class InstituteBean implements Serializable {

    private Institute institute;
    @EJB
    private InstituteDAO dao;

    public InstituteBean() {
    }

    public InstituteBean(Institute institute, InstituteDAO dao) {
        this.institute = institute;
        this.dao = dao;
    }

    public void create() {
        this.dao.create(institute);
        this.institute = new Institute();
    }

    public List<Institute> getRead() {
        return this.dao.findAll();
    }

    public void updateForm(Institute c) {
        this.institute = c;
    }

    public void update() {
        this.dao.edit(institute);
        this.institute = new Institute();
    }

    public Long find(Long id) {
        if (this.dao.find(id) != null) {
            return id;
        } else {
            return null;
        }
    }

    public void delete(Institute c) {
        this.dao.remove(c);

    }

    public Institute getInstitute() {
        if (this.institute == null) {
            return this.institute = new Institute();
        }
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

}
