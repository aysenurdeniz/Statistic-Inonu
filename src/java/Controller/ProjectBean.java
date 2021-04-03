package Controller;

import Dao.ProjectDAO;
import Entities.Project;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "projectBean")
@ViewScoped
public class ProjectBean implements Serializable {

    private Project project;
    @EJB
    private ProjectDAO dao;

    public ProjectBean() {
    }

    public ProjectBean(Project project, ProjectDAO dao) {
        this.project = project;
        this.dao = dao;
    }

    public void create() {
        this.dao.create(project);
        this.project = new Project();
    }

    public List<Project> getRead() {
        return this.dao.findAll();
    }

    public void updateForm(Project c) {
        this.project = c;
    }

    public void update() {
        this.dao.edit(project);
        this.project = new Project();
    }

    public void delete(Project c) {
        this.dao.remove(c);
    }

    public Project getProject() {
        if (this.project == null) {
            return this.project = new Project();
        }
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
