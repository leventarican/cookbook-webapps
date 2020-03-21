package com.github.leventarican.bce;

import javax.ejb.EJB;

/**
 * @author Levent
 */
public class AbstractFoobarControl {
    @EJB(beanName = "DataControlBean")
    DataControl data;
}
