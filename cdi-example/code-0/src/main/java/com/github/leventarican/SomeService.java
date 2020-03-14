package com.github.leventarican;

import javax.ejb.Stateless;
import javax.inject.Named;

@Stateless
@Named
public class SomeService {
    public String hello(String name) {
        return "hello: " + name;
    }
}
