package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.converter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }


    public void convertCurrency(View view) {
//        EditText dollarText = findViewById(R.id.dollarText);
//        TextView textView = findViewById(R.id.textView);

        if(!binding.dollarText.getText().toString().isEmpty())
        {
            float dollarValue = Float.parseFloat(binding.dollarText.getText().toString());

            float euroValue = dollarValue * .85f;

            binding.textView.setText(String.format("%.2f",euroValue));
        }
        else {
            binding.textView.setText("No Value");
        }
    }
}