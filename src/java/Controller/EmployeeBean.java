package Controller;

import Dao.EmployeeDAO;
import Entities.Employee;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "employeeBean")
@ViewScoped
public class EmployeeBean implements Serializable {

    private Employee employee = new Employee();
    @EJB
    private EmployeeDAO dao;

    public EmployeeBean() {
    }

    public EmployeeBean(EmployeeDAO dao) {
        this.dao = dao;
    }
    public void login() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        Employee result = dao.login(employee.getUsername(), employee.getPassword());
        if (result != null) {
            try {
                context.getExternalContext().getSessionMap().put("user", employee.getUsername());
                employee = result;
                context.getExternalContext().redirect("secret/adminprofile.xhtml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("username and password not found"));
        }
    }

    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("/statisticInonu/faces/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployee() {
        if (this.employee == null) {
            return this.employee = new Employee();
        }
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
