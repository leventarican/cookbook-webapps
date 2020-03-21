package com.github.leventarican.bce;

import javax.ejb.EJB;

/**
 * @author Levent
 */
public class AbstractFoobarFacade {
    
    @EJB(beanName = "DataControlBean")
    DataControl data;
    
    @EJB(beanName = "FoobarControlBean")
    FoobarControl foobar;
}
