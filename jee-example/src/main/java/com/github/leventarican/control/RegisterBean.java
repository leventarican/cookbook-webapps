package com.github.leventarican.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.github.leventarican.model.Customer;

@Stateless
public class RegisterBean implements RegisterApi {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createAccount(Customer customer) {
		em.persist(customer);
	}

}
