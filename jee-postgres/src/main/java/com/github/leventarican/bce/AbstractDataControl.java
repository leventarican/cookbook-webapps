package com.github.leventarican.bce;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Levent
 */
public class AbstractDataControl {

    @PersistenceContext(unitName = "developer")
    EntityManager entityManager;

    public AbstractDataControl() {
    }

    public AbstractDataControl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
