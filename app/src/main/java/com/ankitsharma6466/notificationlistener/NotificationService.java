package com.ankitsharma6466.notificationlistener;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class NotificationService extends NotificationListenerService {

    Context context;

    @Override
    public void onCreate() {

        super.onCreate();
        context = getApplicationContext();

    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {

        String pack = sbn.getPackageName();
        String tickerText = sbn.getNotification().tickerText.toString();

        Bundle extras = sbn.getNotification().extras;
        String title = extras.getString("android.title");
        String body = extras.getCharSequence("android.text").toString();

        Log.i("Data >>", "Package : " + pack
                + ", Ticker : " + tickerText
                + ", Title : " + title
                + ", Body : " + body);

        Intent intent = new Intent(Constants.KEY_DATA);
        intent.putExtra(Constants.KEY_PACKAGE, pack);
        intent.putExtra(Constants.KEY_TICKER, tickerText);
        intent.putExtra(Constants.KEY_TITLE, title);
        intent.putExtra(Constants.KEY_BODY, body);

        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.i("Msg", "Notification Removed");
    }
}