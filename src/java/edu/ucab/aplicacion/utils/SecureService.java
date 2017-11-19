package edu.ucab.aplicacion.utils;

import edu.ucab.aplicacion.jpa.UsuarioFacade;
import edu.ucab.aplicacion.model.Usuario;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SecureService {

    @EJB
    private UsuarioFacade usuarioFacade;
    
    public Map<String, Object> checkUser(String username, String password){
        Map<String, Object> validationMap = new ConcurrentHashMap<>();
        boolean checked = false;
        
        Optional<Usuario> usrOpt = usuarioFacade.findUsuarioByName(username);
        if(usrOpt.isPresent()){
            Usuario user = usrOpt.get();
            if(user.getPsw().equals(password)){
                checked = true;
                validationMap.put("user", user);
                validationMap.put("valid", true);           
            }
        } else {
            validationMap.put("valid", false);
        }
        
        return validationMap;
    }
}
