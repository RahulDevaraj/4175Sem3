package com.example.threaddemo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;


import com.example.threaddemo2.databinding.ActivityMainBinding;

import java.security.spec.ECField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {
    Future<String> future;
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
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
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
                return "Task Completed";
            }
        });

        executorService.shutdown();

        };

    public void statusClick(View view) {
        if(future.isDone())
        {
            String result = null;
            try{
                result = future.get(3, TimeUnit.SECONDS);
            }
            catch (ExecutionException| TimeoutException | InterruptedException e)
            {
                e.printStackTrace();
            }
            binding.myTextView.setText(result);
        }
        else {
            binding.myTextView.setText("Waiting");
        }
    }


}
