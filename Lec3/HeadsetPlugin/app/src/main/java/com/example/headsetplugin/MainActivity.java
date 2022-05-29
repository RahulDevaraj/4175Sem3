package com.example.headsetplugin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private CustomReceiver mReceiver = new CustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_HEADSET_PLUG);
        this.registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        // Unregister the receivers.
        super.onDestroy();
        this.unregisterReceiver(mReceiver);

    }
}