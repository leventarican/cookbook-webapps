package com.github.leventarican.control;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class HelloUtil {
    
    private Map memory;
    
    @PostConstruct
    public void init() {
        memory = new HashMap();
    }
    
    public Object get(String key){
        return memory.get(key);
    }
    
    public void store(String key,Object value){
        memory.put(key, value);
    }
    
    public String getRandom() {
        return "#".repeat(new Random(80).nextInt());
    }
}
