package Controller;

import Dao.PhysicalserviceDAO;
import Entities.Physicalservice;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "physicalserviceBean")
@ViewScoped
public class PhysicalserviceBean implements Serializable {

    private Physicalservice physicalservice;
    @EJB
    private PhysicalserviceDAO dao;

    public PhysicalserviceBean() {
    }

    public PhysicalserviceBean(Physicalservice physicalservice, PhysicalserviceDAO dao) {
        this.physicalservice = physicalservice;
        this.dao = dao;
    }

    public void create() {
        this.dao.create(physicalservice);
        this.physicalservice = new Physicalservice();
    }

    public List<Physicalservice> getRead() {
        return this.dao.findAll();
    }

    public void updateForm(Physicalservice c) {
        this.physicalservice = c;
    }

    public void update() {
        this.dao.edit(physicalservice);
        this.physicalservice = new Physicalservice();

    }

    public void delete(Physicalservice c) {
        this.dao.remove(c);

    }

    public Physicalservice getPhysicalservice() {
        if (this.physicalservice == null) {
            return this.physicalservice = new Physicalservice();
        }
        return physicalservice;
    }

    public void setPhysicalservice(Physicalservice physicalservice) {
        this.physicalservice = physicalservice;
    }

}
