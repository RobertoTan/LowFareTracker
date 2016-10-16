package com.sabre.api.sacs.rest.interceptor;

import com.sabre.api.sacs.rest.TokenHolder;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;


/**
 * Interceptor class, which adds the 'Authorization' header to the GET calls.
 */
public class AuthenticatingGetInterceptor implements ClientHttpRequestInterceptor {

    private TokenHolder tokenHolder = TokenHolder.getInstance();
    
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        
        request.getHeaders().add("Authorization", "Bearer " + tokenHolder.getTokenString());
        
        ClientHttpResponse response = execution.execute(request, body);

        return response;
    }

}
