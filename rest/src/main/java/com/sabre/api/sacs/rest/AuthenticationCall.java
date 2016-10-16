package com.sabre.api.sacs.rest;

import android.os.AsyncTask;

import com.sabre.api.sacs.configuration.SacsConfiguration;
import com.sabre.api.sacs.domain.auth.AuthResponse;
import com.sabre.api.sacs.rest.interceptor.LoggingRequestInterceptor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Class creating call for authenticating and obtaining the AuthToken.
 * The call is being used in the TokenHolder class when the token, that
 * is being held there is either expired or not created yet.
 */
public class AuthenticationCall {

    private SacsConfiguration config = com.sabre.api.sacs.configuration.SacsConfiguration.getInstance();
    
    private CredentialsBuilder credentialsBuilder = CredentialsBuilder.getInstance();
    
    private TokenHolder tokenHolder = TokenHolder.getInstance();

    private BlockingQueue<AuthResponse> block = new LinkedBlockingQueue<>();
    
    public void doCall() {

        try {
            new AuthRequestTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            tokenHolder.resetToken(block.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private class AuthRequestTask extends AsyncTask<Void, Void, AuthResponse> {
        @Override
        protected AuthResponse doInBackground(Void... params) {
            RestTemplate restTemplate = new RestTemplate();
            ClientHttpRequestInterceptor ri = new LoggingRequestInterceptor();
            List<ClientHttpRequestInterceptor> ris = new ArrayList<>();
            ris.add(ri);
            restTemplate.setInterceptors(ris);

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("grant_type", "client_credentials");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.add("Authorization", "Basic " + credentialsBuilder.getCredentialsString());
            headers.add("Accept", "*/*");

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(map, headers);
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
            messageConverters.add(new FormHttpMessageConverter());
            messageConverters.add(new MappingJackson2HttpMessageConverter());
            restTemplate.setMessageConverters(messageConverters);
            AuthResponse authToken = restTemplate.postForObject(config.getRestProperty("environment") + "/v2/auth/token", requestEntity, AuthResponse.class);
            block.offer(authToken);
            return authToken;
        }

    }


}
