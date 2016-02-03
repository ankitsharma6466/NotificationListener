package com.ankitsharma6466.notificationlistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout itemParent;
    BroadcastReceiver notificationReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemParent = (LinearLayout) findViewById(R.id.item_parent);
        itemParent.removeAllViews();

        notificationReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {

                String packageName = intent.getStringExtra(Constants.KEY_PACKAGE);
                String tickerText = intent.getStringExtra(Constants.KEY_TICKER);
                String title = intent.getStringExtra(Constants.KEY_TICKER);
                String body = intent.getStringExtra(Constants.KEY_BODY);

                Log.d("Received", packageName + " --- " + tickerText + " --- " + title + " --- " + body);

                View itemView = getLayoutInflater().inflate(R.layout.item_notification, null);
                TextView titleView = (TextView) itemView.findViewById(R.id.item_title);
                TextView bodyView = (TextView) itemView.findViewById(R.id.item_body);
                TextView packageView = (TextView) itemView.findViewById(R.id.item_package);

                titleView.setText(title);
                bodyView.setText(body);
                packageView.setText(packageName);

                itemParent.addView(itemView);
            }
        };

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(notificationReceiver, new IntentFilter(Constants.KEY_DATA));
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(notificationReceiver);
    }
}