package Controller;

import Dao.FacultyDAO;
import Dao.FieldDAO;
import Dao.InstituteDAO;
import Entities.Faculty;
import Entities.Field;
import Entities.Institute;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "fieldBean")
@ViewScoped
public class FieldBean implements Serializable {

    private Field field;
    @EJB
    private FieldDAO dao;
    @EJB
    private FacultyDAO fdao;
    @EJB
    private InstituteDAO idao;

    public FieldBean() {
    }

    public FieldBean(Field field, FieldDAO dao, FacultyDAO fdao, InstituteDAO idao) {
        this.field = field;
        this.dao = dao;
        this.fdao = fdao;
        this.idao = idao;
    }
    
    public void create() {
        this.dao.create(field);
        this.field = new Field();
    }

    public List<Field> getRead() {
        return this.dao.findAll();
    }

    public List<Faculty> getAllFaculty() {
        return this.fdao.findAll();

    }

    public List<Institute> getAllInstitute() {
        return this.idao.findAll();

    }

    public void updateForm(Field c) {
        this.field = c;
    }

    public void update() {
        this.dao.edit(field);
        this.field = new Field();
    }

    public void delete(Field c) {
        this.dao.remove(c);

    }

    public Field getField() {
        if(this.field==null){
            return this.field = new Field();
        }
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
    
}
