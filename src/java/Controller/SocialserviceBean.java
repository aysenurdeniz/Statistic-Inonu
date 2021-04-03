package Controller;

import Dao.SocialserviceDAO;
import Entities.Socialservice;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "socialserviceBean")
@ViewScoped
public class SocialserviceBean implements Serializable{
    
    private Socialservice socialservice ;
    @EJB
    private SocialserviceDAO dao ;

    public SocialserviceBean() {
    }

    public SocialserviceBean(Socialservice socialservice, SocialserviceDAO dao) {
        this.socialservice = socialservice;
        this.dao = dao;
    }
    
    public void create() {
        this.dao.create(socialservice);
        this.socialservice = new Socialservice();
    }

    public List<Socialservice> getRead() {
        return this.dao.findAll();
    }

    public void updateForm(Socialservice c) {
        this.socialservice = c;
    }

    public void update() {
        this.dao.edit(socialservice);
        this.socialservice = new Socialservice();
    }
    public void delete(Socialservice c) { 
        this.dao.remove(c);

    }

    public Socialservice getSocialservice() {
        if(this.socialservice == null){
            return this.socialservice = new Socialservice();
        }
        return socialservice;
    }

    public void setSocialservice(Socialservice socialservice) {
        this.socialservice = socialservice;
    }

    
}
