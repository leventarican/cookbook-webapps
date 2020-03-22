package com.github.leventarican.webservice;

import com.github.leventarican.bce.DataFacade;
import javax.ejb.EJB;
import javax.jws.WebService;

/**
 * @author Levent
 */
@WebService(
        endpointInterface = "com.github.leventarican.webservice.DataService",
        serviceName = "data-service")
public class DataServiceImpl implements DataService {

    @EJB
    DataFacade data;

    @Override
    public String data() {
        return data.getData();
    }

}
