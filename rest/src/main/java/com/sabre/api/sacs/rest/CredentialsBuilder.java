package com.sabre.api.sacs.rest;

import android.util.Base64;

import com.sabre.api.sacs.configuration.SacsConfiguration;


/**
 * Class responsible for creating the authentication string
 * based on the credentials held in the Configuration.
 */
public class CredentialsBuilder {
    
    private static CredentialsBuilder instance;

    private SacsConfiguration config = com.sabre.api.sacs.configuration.SacsConfiguration.getInstance();


    private CredentialsBuilder() {

    }

    public static CredentialsBuilder getInstance() {
        if (instance == null) {
            instance = new CredentialsBuilder();
        }
        return instance;
    }
    /**
     * Constructs the credentials string. It gets the required data from
     * the Configuration module and encodes it as it is described here:
     * {@link https://developer.sabre.com/docs/read/rest_basics/authentication}
     * @return the encoded credentials to be used in the authentication header.
     */
    public String getCredentialsString() {
        StringBuilder credentials = new StringBuilder();
        
        credentials.append(config.getRestProperty("formatVersion"))
            .append(":")
            .append(config.getRestProperty("userId"))
            .append(":")
            .append(config.getRestProperty("group"))
            .append(":")
            .append(config.getRestProperty("domain"));
        
        String secret = b64(config.getRestProperty("clientSecret"));
        return b64(b64(credentials.toString()) + ":" + secret);
    }
    
    //just a shortcut method
    private String b64(String toEncode) {
        return new String(Base64.encode(toEncode.getBytes(), Base64.NO_WRAP));
    }
}
