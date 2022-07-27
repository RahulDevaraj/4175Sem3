package com.example.standupcodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickButton(View view) {
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        AlarmManager.AlarmClockInfo alarmClockInfo = alarmManager.getNextAlarmClock();
        String message;
        if (alarmClockInfo != null){
            Date nextAlarm = new Date(alarmClockInfo.getTriggerTime());
            String printDate = DateFormat.getTimeInstance().format(nextAlarm);

            message = "The alarm is set for " + printDate + ".";
        }
        else{
            message = "No alarm scheduled.";
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}