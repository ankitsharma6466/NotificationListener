package com.ankitsharma6466.notificationlistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(onNotice, new IntentFilter(Constants.KEY_DATA));
    }

    private BroadcastReceiver onNotice = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            String packageName = intent.getStringExtra(Constants.KEY_PACKAGE);
            String tickerText = intent.getStringExtra(Constants.KEY_TICKER);
            String title = intent.getStringExtra(Constants.KEY_TICKER);
            String body = intent.getStringExtra(Constants.KEY_BODY);


//            TableRow tr = new TableRow(getApplicationContext());
//            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//            TextView textview = new TextView(getApplicationContext());
//            textview.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
//            textview.setTextSize(20);
//            textview.setTextColor(Color.parseColor("#0B0719"));
//            textview.setText(Html.fromHtml(pack + "<br><b>" + title + " : </b>" + text));
//            tr.addView(textview);
//            tab.addView(tr);


        }
    };
}