package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int count;

    TextView battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        count = 0;

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(null, ifilter);
        int batteryLevel = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        battery = (TextView)findViewById(R.id.battery_per);
        battery.setText("Battery Level: " + String.valueOf(batteryLevel) + "%");

    }

    public void changeText(View v) {
        ((Button) v).setText("Hello");
    }

    public void plus(View v) {
        count++;
        textView.setText(String.valueOf(count));
    }

    public void minus(View v) {
        count--;
        textView.setText(String.valueOf(count));
    }

    public void multi(View v) {
        count *= 2;
        textView.setText(String.valueOf(count));
    }

    public void divide(View v) {
        count /= 2;
        textView.setText(String.valueOf(count));
    }

    public void goto_main2(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}