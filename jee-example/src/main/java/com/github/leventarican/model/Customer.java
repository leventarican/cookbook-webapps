package com.github.leventarican.model;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * JavaBean (= constructor without parameter and serializable)
 *
 * @author Levent
 */
@Entity
public class Customer implements Serializable {
    
    private String mail;
    private String password;

    public Customer() {}
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
