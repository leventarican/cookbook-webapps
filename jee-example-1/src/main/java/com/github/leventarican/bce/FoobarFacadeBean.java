package com.github.leventarican.bce;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author Levent
 */
@Remote(FoobarFacade.class)
@Stateless(mappedName = "com.github.leventarican.bce.FoobarFacade")
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class FoobarFacadeBean extends AbstractFoobarFacade implements FoobarFacade {    
    
    @Override
    public String ping() {
        return foobar.ping();
    }

    @Override
    public String developer() {
        return foobar.developer();
    }
    
    
}
