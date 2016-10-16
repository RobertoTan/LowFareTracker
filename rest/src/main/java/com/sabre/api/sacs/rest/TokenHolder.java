package com.sabre.api.sacs.rest;

import com.sabre.api.sacs.domain.auth.AuthResponse;

import java.util.Calendar;
import java.util.Date;


/**
 * Class controlling the usage of the authentication token. If the 
 * token has expired or was not created yet, it sends the authentication
 * call.
 */
public class TokenHolder {

    private static TokenHolder instance;

    private AuthResponse token;
    
    private Date expirationDate;
    

    private TokenHolder() {

    }

    public static TokenHolder getInstance() {
        if (instance == null) {
            instance = new TokenHolder();
        }
        return instance;
    }
    /**
     * Retrieves the authentication token. If the token has expired,
     * it sends the authentication call.
     * @return token string to be used in all calls.
     */
    public String getTokenString() {
        if (expirationDate == null || new Date().getTime() > expirationDate.getTime()) {
            new AuthenticationCall().doCall();
        }
        return token.getAccessToken();
    }
    
    /**
     * Sets the token and resets it's expiration time.
     * @param token the new token to be set.
     */
    public void resetToken(AuthResponse token) {
        this.token = token;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, Integer.parseInt(token.getExpiresIn()));
        expirationDate = cal.getTime();
    }
}
