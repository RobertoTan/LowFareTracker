package com.sabre.api.sacs.sabreapicodesamples.activity;

import android.os.Debug;
import android.util.Log;

import com.sabre.api.sacs.configuration.SacsConfiguration;
import com.sabre.api.sacs.rest.AuthenticationCall;
import com.sabre.api.sacs.rest.TokenHolder;
import com.sabre.api.sacs.workflow.Activity;
import com.sabre.api.sacs.workflow.SharedContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yuzhigang on 10/15/16.
 */

public class LowFareForecastActivity implements Activity {
    private static String TAG = "LowFareForecast";
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private String fareBar;

    public LowFareForecastActivity(String origin, String destination, String departureDate, String returnDate, String fareBar) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.fareBar = fareBar;
    }

    public JSONObject getLowFareForeCast(TokenHolder tokenHolder) {
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        URL url = null;
        try {
            url = new URL("https://api.test.sabre.com/v1/forecast/flights/fares?" +
                    "origin=" + origin + "&destination=" + destination +"&departuredate=" +
                    departureDate + "&returndate=" + returnDate);

            conn = (HttpURLConnection)url.openConnection();
            //HttpURLConnection默认就是用GET发送请求，所以下面的setRequestMethod可以省略
            conn.setRequestMethod("GET");
            //HttpURLConnection默认也支持从服务端读取结果流，所以下面的setDoInput也可以省略
            conn.setDoInput(true);

            conn.setRequestProperty("Authorization", "Bearer " + tokenHolder.getTokenString());

            conn.connect();

            inputStream = new BufferedInputStream(conn.getInputStream());

            int r = 0;
            byte[] buff = new byte[1024];
            StringBuilder strBuf = new StringBuilder();
            while ((r = inputStream.read(buff)) > 0) {
                strBuf.append(new String(buff, 0, r));
            }

            JSONObject lowFare = new JSONObject(strBuf.toString());
            Log.v(TAG, "LowFare is:" + lowFare.toString());

            return lowFare;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(JSONException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public Activity run(SharedContext context) {
        return null;
    }
}
