package com.sabre.api.sacs.configuration;

import android.os.AsyncTask;

import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by SG0946321 on 9/28/2015.
 */
public class HttpConfigReader implements ConfigReader {

    private BlockingQueue<Map<String, String>> block = new LinkedBlockingQueue<>();

    public Properties getConfig() {
        Properties result = new Properties();
        new ConfigHttpTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        try {
            Map<String, String> config = block.take();
            result.putAll(config);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    private class ConfigHttpTask extends AsyncTask<Void, Void, Map<String, String>> {

        @Override
        protected Map<String, String> doInBackground(Void... params) {
            RestTemplate restTemplate = new RestTemplate();
            Map<String, String> result = restTemplate.getForObject(BuildConfig.AUTH_URL, Map.class);
            block.offer(result);
            return result;
        }
    }
}
