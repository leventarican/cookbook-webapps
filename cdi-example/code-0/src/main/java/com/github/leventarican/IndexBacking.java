package com.github.leventarican;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.CDI;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.InitialContext;

@Named
@RequestScoped
@FacesConfig
public class IndexBacking {
    
    SomeService ejbContainter, jsfContainter, cdiContainter = null;
    
    public String onLoad() throws Exception {
        ejbContainter = (SomeService) new InitialContext().lookup("java:module/SomeService");
        jsfContainter = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),"#{someService}",SomeService.class);
        cdiContainter = CDI.current().select(SomeService.class).get();
        return null;
    }
    
    public String pingEJB() {
        return ejbContainter.hello("EJB");
    }
    
    public String pingJSF() {
        return jsfContainter.hello("JSF");
    }
    
    public String pingCDI() {
        return cdiContainter.hello("CDI");
    }
}
