package com.github.leventarican.bce;

import javax.persistence.EntityManager;

/**
 * @author Levent
 */
public interface DataControl {
    
    public EntityManager getEntityManager();
    
    public String getDeveloper();
}
