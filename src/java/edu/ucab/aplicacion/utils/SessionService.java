package edu.ucab.aplicacion.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionService {
    
    public static HttpSession getSession(){
        return (HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false);
    }
}
