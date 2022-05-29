package com.example.headsetplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if (intentAction != null) {
            String toastMessage = "unknown Action";
            switch (intentAction){
                case Intent.ACTION_HEADSET_PLUG:
                    toastMessage = "Headset Connection Status Changed";
                    break;
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }

    }
}