/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucab.aplicacion.jpa;

import edu.ucab.aplicacion.model.Usuario;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author LAB_A553
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "aplicacionweb1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Optional<Usuario> findUsuarioByName(String username){
        Optional<Usuario> userOpt = Optional.empty();
        try {
            String query = "FROM Usuario u WHERE u.usr = :username";
            TypedQuery<Usuario> q = getEntityManager().createQuery(query, Usuario.class);
            q.setParameter("username", username);
            userOpt = Optional.ofNullable(q.getSingleResult());
        } catch (Exception e) {
            Logger.getLogger(UsuarioFacade.class.getName()).log(Level.SEVERE, e.getMessage());
        }
        return userOpt;
    }
}
