package Controller;

import Dao.AcademicianDAO;
import Entities.Academician;
import Enums.Staff;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "academicianBean")
@ViewScoped
public class AcademicianBean implements Serializable {

    private Academician academician;
    @EJB
    private AcademicianDAO dao;

    public AcademicianBean() {
    }

    public AcademicianBean(Academician entity, AcademicianDAO dao) {
        this.academician = entity;
        this.dao = dao;
    }

    public void create() {
        this.dao.create(academician);
        this.academician = new Academician();
    }

    public List<Academician> getRead() {
        return this.dao.findAll();
    }

    public void updateForm(Academician c) {
        this.academician = c;
    }

    public void update() {
        this.dao.edit(academician);
        this.academician = new Academician();

    }

    public void delete(Academician c) {
        this.dao.remove(c);

    }

    public Staff[] getStaff() {
        return Staff.values();
    }

    public List<Academician> staffCount() {
        return this.dao.countStaff();
    }

    public Academician getAcademician() {
        if (this.academician == null) {
            return this.academician = new Academician();
        }
        return academician;
    }

    public void setAcademician(Academician academician) {
        this.academician = academician;
    }

}
