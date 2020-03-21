package com.github.leventarican.webservice;

import com.github.leventarican.bce.FoobarFacade;
import javax.ejb.EJB;
import javax.jws.WebService;

/**
 * http://localhost:8080/YOUR-CONTEXT-ROOT/customer-service?wsdl
 * 
 * @author Levent
 */
@WebService(
        endpointInterface = "com.github.leventarican.webservice.CustomerService", 
        serviceName = "customer-service")
public class CustomerServiceImpl implements CustomerService {

    @EJB
    FoobarFacade facade;
    
    @Override
    public String welcome() {
//        return "hello form: " + CustomerService.class.getSimpleName();
//        return facade.ping();
        return facade.developer();
    }
}
