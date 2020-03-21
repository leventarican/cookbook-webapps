package com.github.leventarican.bce;

import com.github.leventarican.model.ProgrammingLanguages;
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
    public String getUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDeveloper() {
        Query query = entityManager.createQuery("SELECT * FROM PROGRAMMINGLANGUAGES");
        ProgrammingLanguages result = (ProgrammingLanguages) query.getSingleResult();

        return "### " + result.getName() + " ###";
    }

}
