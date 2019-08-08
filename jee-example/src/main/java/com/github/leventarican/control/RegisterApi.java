package com.github.leventarican.control;

import javax.ejb.Remote;

import com.github.leventarican.model.Customer;

/**
 * on server cluster we should use remote
 * otherwise if same vm we can use @Local
 * 
 * @author Levent
 */
@Remote
public interface RegisterApi {
	public void createAccount(Customer customer);
}
