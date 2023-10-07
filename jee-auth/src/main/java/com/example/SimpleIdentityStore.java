package com.example;

import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
public class SimpleIdentityStore implements IdentityStore {
    
    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        if ("username".equals(usernamePasswordCredential.getCaller()) 
             && "password".equals(usernamePasswordCredential.getPasswordAsString())) {
            return new CredentialValidationResult("username", new HashSet<String>(Arrays.asList("admin")));
        }
        return CredentialValidationResult.INVALID_RESULT;
    }
}
