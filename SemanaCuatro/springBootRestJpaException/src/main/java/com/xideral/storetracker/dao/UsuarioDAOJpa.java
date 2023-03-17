package com.xideral.storetracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xideral.storetracker.entity.Usuario;

@Repository
public class UsuarioDAOJpa implements UsuarioDAO {
	
    // define field for entitymanager
    private EntityManager entityManager;
    
    // set up constructor injection
    @Autowired
    public UsuarioDAOJpa(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


	@Override
	public List<Usuario> getUsuarios() {
		System.out.println("PASO POR UsuarioDAOJpa");
		// create a query
        TypedQuery<Usuario> theQuery = entityManager.createQuery("from Usuario", Usuario.class);

        // execute query and get result list
        List<Usuario> usuarios = theQuery.getResultList();

        // return the results
        return usuarios;
	}

	//Método para actualizar o guardar usuario
	@Override
	public Usuario saveUsuario(Usuario theUsuario) {
		Usuario usuario = null;
		if (theUsuario.getIdusuario() == 0)// => UPDATE
			usuario = entityManager.find(Usuario.class, theUsuario.getIdusuario());
		
		//if id != 0 => SAVE
		usuario = entityManager.merge(theUsuario);
		
		return usuario;
	}

	@Override
	public Usuario getUsuario(int theId) {
		Usuario theUsuario = entityManager.find(Usuario.class, theId);
		return theUsuario;
	}

	@Override
	public void deleteUsuario(int theId) {
		Usuario theUsuario = entityManager.find(Usuario.class, theId);
        entityManager.remove(theUsuario);
		
	}

}
