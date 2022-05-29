package com.example.powerreceiverhw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String RANDOM_NUMBER = BuildConfig.APPLICATION_ID+".RANDOM_NUMBER";

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String randomNumberString = intent.getStringExtra(RANDOM_NUMBER);
        int num=0;
        if(randomNumberString!=null)
            num = Integer.parseInt(randomNumberString);

        if (intentAction != null) {
            String toastMessage = "unknown Action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage ="Power disconnected!";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage =
                            "Custom Broadcast Received \nSquare of the Random NUmber :"+(num*num);
                    break;
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}