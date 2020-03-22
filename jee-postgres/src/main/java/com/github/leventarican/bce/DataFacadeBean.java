package com.github.leventarican.bce;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author Levent
 */
@Remote(DataFacade.class)
@Stateless(mappedName = "com.github.leventarican.bce.DataFacade")
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DataFacadeBean extends AbstractDataFacade implements DataFacade {

    @Override
    public String getData() {
        return data.getDeveloper();
    }

}
