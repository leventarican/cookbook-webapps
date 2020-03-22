package com.github.leventarican.bce;

import com.github.leventarican.model.Developers;
import java.util.Random;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author Levent
 */
@Stateless(mappedName = "com.github.leventarican.bce.DataControl")
@Local(DataControl.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DataControlBean extends AbstractDataControl implements DataControl {

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public String getDeveloper() {
        int random = new Random().nextInt(3);
        Query query = entityManager.createNamedQuery("Developers.findById");
        query.setParameter("id", random);
        return ((Developers) query.getResultList().get(0)).getName();
    }

}
