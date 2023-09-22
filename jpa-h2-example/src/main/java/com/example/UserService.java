package com.example;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class UserService {
	
    @PersistenceContext(unitName = "myPU")
    private EntityManager em;
    
    public User saveUser(String name) {
    	User user = new User();
    	user.setUser(name);
    	user.setRole("READER");
    	em.persist(user);
        return user;
    }
    
    public List<User> listAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
    
    public User findUser(String user) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.user = :user", User.class);
        query.setParameter("user", user);
        
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
