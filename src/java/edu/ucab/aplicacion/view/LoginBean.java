package edu.ucab.aplicacion.view;

import edu.ucab.aplicacion.model.Usuario;
import edu.ucab.aplicacion.utils.SecureService;
import edu.ucab.aplicacion.utils.SessionService;
import java.io.Serializable;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    
    private String username;
    private String password;
    private Usuario current;
    
    @EJB
    private SecureService secureService;
    
    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Usuario getCurrent() {
        return current;
    }
    
    public String login(){
        System.out.println("Llegó al login");
        FacesMessage msg = null;
        String result = "";
        HttpSession session = SessionService.getSession();
        Map<String, Object> validationMap = secureService.checkUser(username, password);
        boolean valid = (Boolean)validationMap.get("valid");
        if(valid){
            session.setAttribute("username", username);
            current = (Usuario)validationMap.get("user");
            result = "usuario/List?faces-redirect=true";
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvendo", username);
        } else {
            session.setAttribute("username", "");
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error de Ingreso",
                    "Credenciales inválidas");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return result;
    }
    
    public String logout(){
        HttpSession session = SessionService.getSession();
        session.removeAttribute(username);
        session.invalidate();
        return "/index?faces-redirect=true";
    }

    
}
