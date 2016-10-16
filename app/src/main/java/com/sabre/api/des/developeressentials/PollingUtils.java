package com.sabre.api.des.developeressentials;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import static com.sabre.api.CommonKey.KEY_DEPARTURE_DATE;
import static com.sabre.api.CommonKey.KEY_DESTINATION;
import static com.sabre.api.CommonKey.KEY_FARE_BAR;
import static com.sabre.api.CommonKey.KEY_ORIGIN;
import static com.sabre.api.CommonKey.KEY_RETURN_DATE;

/**
 * Created by yuzhigang on 10/16/16.
 */

public class PollingUtils {
    public static void startPollingService(Context context, int seconds, Class<?> cls, String action, Bundle req) {
        //获取AlarmManager系统服务
        AlarmManager manager = (AlarmManager) context
                .getSystemService(Context.ALARM_SERVICE);

        //包装需要执行Service的Intent
        Intent intent = new Intent(context, cls);
        intent.setAction(action);
        intent.putExtra(KEY_ORIGIN, req.getString(KEY_ORIGIN));
        intent.putExtra(KEY_DESTINATION, req.getString(KEY_DESTINATION));
        intent.putExtra(KEY_DEPARTURE_DATE, req.getString(KEY_DEPARTURE_DATE));
        intent.putExtra(KEY_RETURN_DATE, req.getString(KEY_RETURN_DATE));
        intent.putExtra(KEY_FARE_BAR, req.getString(KEY_FARE_BAR));
        PendingIntent pendingIntent = PendingIntent.getService(context, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //使用AlarmManger的setRepeating方法设置定期执行的时间间隔（seconds秒）和需要执行的Service
        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
                seconds * 1000, pendingIntent);
    }
    //停止轮询服务
    public static void stopPollingService(Context context, Class<?> cls,String action) {
        AlarmManager manager = (AlarmManager) context
                .getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, cls);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //取消正在执行的服务
        manager.cancel(pendingIntent);
    }
}
