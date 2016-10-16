package com.sabre.api.des.developeressentials;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.sabre.api.sacs.rest.AuthenticationCall;
import com.sabre.api.sacs.rest.TokenHolder;
import com.sabre.api.sacs.sabreapicodesamples.R;
import com.sabre.api.sacs.sabreapicodesamples.ShowResultsActivity;
import com.sabre.api.sacs.sabreapicodesamples.WorkflowRunnerActivity;
import com.sabre.api.sacs.sabreapicodesamples.activity.LowFareForecastActivity;

import org.json.JSONException;
import org.json.JSONObject;

import static com.sabre.api.CommonKey.KEY_DEPARTURE_DATE;
import static com.sabre.api.CommonKey.KEY_DESTINATION;
import static com.sabre.api.CommonKey.KEY_FARE_BAR;
import static com.sabre.api.CommonKey.KEY_LOW_FARE_RESULT;
import static com.sabre.api.CommonKey.KEY_ORIGIN;
import static com.sabre.api.CommonKey.KEY_RETURN_DATE;

public class LowFareService extends Service {
    public static String ACTION = "com.sabre.api.des.developeressentials";
    private static String TAG = "LowFareService";

    public LowFareService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AuthenticationCall auth = new AuthenticationCall();
        auth.doCall();
        TokenHolder tokenHolder = TokenHolder.getInstance();
        new RetrieveFeedTask().execute(tokenHolder, intent);

        return Service.START_NOT_STICKY;
    }


    class RetrieveFeedTask extends AsyncTask<Object, Integer, JSONObject> {

        protected JSONObject doInBackground(Object... tokenHolders) {
            try {
                Intent intent = (Intent)tokenHolders[1];

                LowFareForecastActivity lowFareForecastActivity = new LowFareForecastActivity(
                        intent.getStringExtra(KEY_ORIGIN).toUpperCase(),
                        intent.getStringExtra(KEY_DESTINATION).toUpperCase(),
                        intent.getStringExtra(KEY_DEPARTURE_DATE),
                        intent.getStringExtra(KEY_RETURN_DATE),
                        intent.getStringExtra(KEY_FARE_BAR));

                JSONObject result = lowFareForecastActivity.getLowFareForeCast((TokenHolder)tokenHolders[0]);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        protected void onPostExecute(JSONObject result) {
            if (result == null) {
                Log.e(TAG, "Failue to get LowFare");
            } else {
                Log.i(TAG, "Flow Fare Result:" + result.toString());
                try {
                    String recommendation = result.getString("Recommendation");

                    if (recommendation != null && recommendation.toUpperCase().startsWith("BUY")) {

                        Intent intent = new Intent(LowFareService.this, ShowResultsActivity.class);
                        intent.putExtra(KEY_LOW_FARE_RESULT, result.toString());
                        NotificationManager mNotifyMgr =
                                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        PendingIntent contentIntent = PendingIntent.getActivity(
                                LowFareService.this, 0, intent, 0);

                        Notification notification = new Notification.Builder(LowFareService.this)
                                .setContentTitle("Low Fare Comes")
                                .setContentText(result.getString("OriginLocation") + " to "
                                +result.getString("DestinationLocation") +":"
                                        +result.getString("LowestFare") + result.getString("CurrencyCode"))
                                .setContentIntent(contentIntent)
                                .setAutoCancel(true)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .build();// getNotification()

                        notification.defaults = Notification.DEFAULT_ALL; // 使用默认设置，比如铃声、震动、闪灯
                        notification.flags = Notification.FLAG_AUTO_CANCEL; // 但用户点击消息后，消息自动在通知栏自动消失
                        notification.flags |= Notification.FLAG_NO_CLEAR;// 点击通知栏的删除，消息不会依然不会被删除

                        mNotifyMgr.notify(0, notification);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
