package com.github.leventarican.bce;

import javax.ejb.EJB;

/**
 * @author Levent
 */
public class AbstractDataFacade {
    @EJB(beanName = "DataControlBean")
    DataControl data;
}
