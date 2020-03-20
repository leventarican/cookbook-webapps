package com.github.leventarican.control;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements HelloApi {

    @Override
    public String ping() {
        return "pong";
    }

}
