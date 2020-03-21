package com.github.leventarican.bce;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author Levent
 */
@Local(FoobarControl.class)
@Stateless(mappedName = "com.github.leventarican.bce.FoobarControl")
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class FoobarControlBean extends AbstractFoobarControl implements FoobarControl {
    @Override
    public String ping() {
        return "ping from: " + FoobarControl.class.getSimpleName();
    }

    @Override
    public String developer() {
        return data.getDeveloper();
    }
}
