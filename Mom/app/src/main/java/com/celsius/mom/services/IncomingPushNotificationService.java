package com.celsius.mom.services;

import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class IncomingPushNotificationService extends NotificationListenerService {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {


        try {
            String pack = sbn.getPackageName();
            String ticker = "";
            if (sbn.getNotification().tickerText != null) {
                ticker = sbn.getNotification().tickerText.toString();
            }
            Bundle extras = sbn.getNotification().extras;
            String title = extras.getString("android.title");
            String text = extras.getCharSequence("android.text").toString();
            String postTime = String.valueOf(sbn.getPostTime());



        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    @Override

    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.i("Msg","Notification Removed");

    }
}
