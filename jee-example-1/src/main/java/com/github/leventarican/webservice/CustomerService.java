package com.github.leventarican.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Levent
 */
@WebService
public interface CustomerService {
    
    @WebMethod
    String welcome();
}
