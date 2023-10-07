package com.example;

import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import java.util.Arrays;
import java.util.HashSet;

@ApplicationScoped
public class CustomHttpAuthenticationMechanism implements HttpAuthenticationMechanism {

	@Inject
	SimpleIdentityStore identityStore;
	
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) {
        String authorizationHeader = request.getHeader("Authorization");
        System.out.println("AUTH HEADER: " + authorizationHeader);
        if (authorizationHeader != null) {
            System.out.println("NOTIFY");
            return httpMessageContext.notifyContainerAboutLogin("username", new HashSet<String>(Arrays.asList("admin")));
        }

        if (httpMessageContext.isProtected()) {
            System.out.println("PROTECED");
            return httpMessageContext.responseUnauthorized();
        }

        return httpMessageContext.doNothing();
    }
}
