package com.sabre.api.sacs.rest;

import android.os.AsyncTask;

import com.sabre.api.sacs.configuration.SacsConfiguration;
import com.sabre.api.sacs.domain.BaseDomainResponse;
import com.sabre.api.sacs.rest.interceptor.LoggingRequestInterceptor;
import com.sabre.api.sacs.workflow.SharedContext;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by SG0946321 on 9/22/2015.
 */
public class GenericRestPostCall<RQ, RS> {

    private SacsConfiguration config = SacsConfiguration.getInstance();

    private TokenHolder tokenHolder = TokenHolder.getInstance();

    private RQ request;

    private String url;

    private BlockingQueue<BaseDomainResponse<RS>> block = new LinkedBlockingQueue<>();

    /**
     * Adds interceptors, creates request string, adds request body and sends the request.
     * Returns the response object.
     * @param cls Class of the response object.
     * @return response object.
     */
    public BaseDomainResponse<RS> doCall(Class<RS> cls, SharedContext context) {
        BaseDomainResponse<RS> result = null;
        try {
            new HttpPostTask(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, cls);
            result = block.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setRequest(RQ request) {
        this.request = request;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private class HttpPostTask extends AsyncTask<Class<RS>, Void, RS> {

        private SharedContext context;

        HttpPostTask(SharedContext context) {
            this.context = context;
        }

        @Override
        protected RS doInBackground(Class<RS>... params) {
            RestTemplate restTemplate = new RestTemplate();
            ClientHttpRequestInterceptor ri = new LoggingRequestInterceptor();
            List<ClientHttpRequestInterceptor> ris = new ArrayList<ClientHttpRequestInterceptor>();
            ris.add(ri);
            restTemplate.setInterceptors(ris);


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Authorization", "Bearer " + tokenHolder.getTokenString());
            headers.add("Accept", "*/*");

            HttpEntity<RQ> requestEntity = new HttpEntity<>(request,
                    headers);

            List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
            messageConverters.add(new FormHttpMessageConverter());
            messageConverters.add(new MappingJackson2HttpMessageConverter());
            restTemplate.setMessageConverters(messageConverters);
            BaseDomainResponse<RS> result = new BaseDomainResponse<>();
            RS callResult = null;
            try {
                callResult = restTemplate.postForObject(url, requestEntity, params[0]);
            } catch (HttpClientErrorException e) {
                result.setStatus(e.getStatusCode().value());
                context.setFaulty(true);
            }
            result.setResult(callResult);
            block.offer(result);
            return null;
        }
    }
}
