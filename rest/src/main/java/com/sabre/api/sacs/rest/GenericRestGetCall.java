package com.sabre.api.sacs.rest;

import android.os.AsyncTask;

import com.sabre.api.sacs.domain.BaseDomainRequest;
import com.sabre.api.sacs.domain.BaseDomainResponse;
import com.sabre.api.sacs.rest.interceptor.AuthenticatingGetInterceptor;
import com.sabre.api.sacs.rest.interceptor.LoggingRequestInterceptor;
import com.sabre.api.sacs.workflow.SharedContext;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by SG0946321 on 9/22/2015.
 */
public class GenericRestGetCall<RQ extends BaseDomainRequest, RS> {

    private String url;

    private RQ request;

    private BlockingQueue<BaseDomainResponse<RS>> block = new LinkedBlockingQueue<>();

    /**
     * Adds interceptors, creates request string with query and sends the request.
     * Returns the response object.
     * @param cls Class of the response object.
     * @return response object.
     */
    public BaseDomainResponse<RS> doCall(Class<RS> cls, SharedContext context) {
        BaseDomainResponse<RS> result = new BaseDomainResponse<>();
        try {
            new HttpGetTask<RS>(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, cls);
            result = block.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String getRequestString() {
        String result = new String(url);

        if (request != null) {
            result += request.toRequestQuery();
        }

        return result;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRequest(RQ request) {
        this.request = request;
    }

    private class HttpGetTask<RSP> extends AsyncTask<Class<RSP>, Void, Void> {

        private SharedContext context;

        HttpGetTask(SharedContext context) {
            this.context = context;
        }

        @Override
        protected Void doInBackground(Class<RSP>... params) {
            RestTemplate restTemplate = new RestTemplate();
            List<ClientHttpRequestInterceptor> ris = new ArrayList<>();
            ris.add(new LoggingRequestInterceptor());
            ris.add(new AuthenticatingGetInterceptor());
            restTemplate.setInterceptors(ris);

            BaseDomainResponse<RSP> result = new BaseDomainResponse<>();
            try {
                result.setResult(restTemplate.getForObject(getRequestString(), params[0], new Object[]{}));
            } catch (HttpClientErrorException e) {
                result.setStatus(e.getStatusCode().value());
                context.setFaulty(true);
            }

            block.offer((BaseDomainResponse<RS>) result);
            return null;
        }
    }

}
