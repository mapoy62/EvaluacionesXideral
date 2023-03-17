package com.xideral.storetracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xideral.storetracker.entity.Compra;
import com.xideral.storetracker.entity.Usuario;

@Repository
public class CompraDAOJpa implements CompraDAO {
	
    // define field for entitymanager
    private EntityManager entityManager;
    
    // set up constructor injection
    @Autowired
    public CompraDAOJpa(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    
	@Override
	public List<Compra> getCompras(int theId) {
		System.out.println("PASO POR CompraDAOJpa");
		// create a query to list shoping of each user
        TypedQuery<Compra> theQuery = entityManager.createQuery("from Compra where idusuario.idusuario = :theId", Compra.class);
        theQuery.setParameter("theId", theId);
         
        // execute query and get result list
        List<Compra> compras = theQuery.getResultList();;

        // return the results
        return compras;
	}

	//Method for save or update
	@Override
	public Compra saveCompra(Compra theCompra) {
		Compra compra = null;
		if (theCompra.getIdcompra() == 0)// => UPDATE
			compra = entityManager.find(Compra.class, theCompra.getIdcompra());
		
		//if id != 0 => SAVE
		compra = entityManager.merge(theCompra);
		
		return compra;
	}

	@Override
	public Compra getCompra(int theId) {
		Compra theCompra = entityManager.find(Compra.class, theId);
		return theCompra;
	}

	@Override
	public void deleteCompra(int theId) {
		Compra theCompra = entityManager.find(Compra.class, theId);
        entityManager.remove(theCompra);
		
	}

}
