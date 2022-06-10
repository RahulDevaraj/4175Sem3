package com.example.mywebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.mywebview.databinding.ActivityMainBinding;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        handleIntent();
    }

    private void handleIntent() {
        Intent intent = getIntent();

        Uri data = intent.getData();
        URL url = null;

        try {
            url = new URL(data.getScheme(),data.getHost(),data.getPath());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        binding.webView1.loadUrl(url.toString());
    }
}