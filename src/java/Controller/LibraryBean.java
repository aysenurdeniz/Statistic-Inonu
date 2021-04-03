package Controller;

import Dao.LibraryDAO;
import Entities.Library;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "libraryBean")
@ViewScoped
public class LibraryBean implements Serializable{
    
    private Library library ;
    @EJB
    private LibraryDAO dao ;

    public LibraryBean() {
    }

    public LibraryBean(Library library, LibraryDAO dao) {
        this.library = library;
        this.dao = dao;
    }
    
    public void create() {
        this.dao.create(library);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, " successfully", "OK");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public List<Library> getRead() {
        return this.dao.findAll();
    }

    public void updateForm(Library c) {
        this.library = c;
    }

    public void update() {
        this.dao.edit(library);
        this.library = new Library();
    }
    
    public void delete(Library c) {
        this.dao.remove(c);
    }

    public Library getLibrary() {
        if(this.library == null){
            return this.library = new Library();
        }
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
    
}
