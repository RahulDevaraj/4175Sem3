package com.example.threaddemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import com.example.threaddemo.databinding.ActivityMainBinding;

import java.security.spec.ECField;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    //for msg callback
    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String string = bundle.getString("myKey");
            binding.myTextView.setText(string);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void buttonClick(View view) {
            Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long endTime = System.currentTimeMillis() + 20*1000;
                while(System.currentTimeMillis() < endTime)
                {
                    synchronized (this)
                    {
                        try {
                            wait(endTime-System.currentTimeMillis());
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
                //display msg
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd G 'at' HH:mm:ss z");
                String currentDateTime = simpleDateFormat.format(new Date());
                bundle.putString("myKey",currentDateTime);
                message.setData(bundle);
                handler.sendMessage(message);

            }
        };
        Thread myThread = new Thread(runnable);
        myThread.start();


    }
}