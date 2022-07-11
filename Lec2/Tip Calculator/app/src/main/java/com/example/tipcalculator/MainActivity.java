package com.example.tipcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tipcalculator.databinding.ActivityMainBinding;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private float tipPercent = .15f;
    private float billAmount = 0.0f ;

    private EditText editTextBillAmount;
    private TextView textViewPercentValue;
    private Button buttonPositive;
    private Button buttonNegative;
    private TextView textViewTotalAmount;
    private TextView textViewTipValue;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        editTextBillAmount = binding.editTextBillAmount;
        buttonPositive = binding.buttonPositive;
        buttonNegative = binding.buttonNegative;
        textViewPercentValue = binding.textViewPercentValue;
        textViewTotalAmount = binding.textViewTotalAmount;
        textViewTipValue = binding.textViewTipValue;


        calculateAndDisplay();
        editTextBillAmount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                calculateAndDisplay();
                return false;
            }
        });

        buttonPositive.setOnClickListener((View view) -> {

            tipPercent += .01f;
             calculateAndDisplay();
        });

        buttonNegative.setOnClickListener((View view) -> {

            tipPercent -= .01f;
            calculateAndDisplay();
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat("tipPercent",tipPercent);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null)
        {
            tipPercent = savedInstanceState.getFloat("tipPercent",.15f);
            calculateAndDisplay();
        }
    }

    private void calculateAndDisplay() {
        float tip,total;

       if(editTextBillAmount.getText().toString().equals(""))
        {
            billAmount = 0.0f;
        }
        else
        {
            billAmount = Float.parseFloat(editTextBillAmount.getText().toString());
        }



        tip =  billAmount*tipPercent;
        total = billAmount+tip;


        NumberFormat percent = NumberFormat.getPercentInstance();
        textViewPercentValue.setText(percent.format(tipPercent));


        NumberFormat currency = NumberFormat.getCurrencyInstance();
        textViewTipValue.setText(currency.format(tip));
        textViewTotalAmount.setText(currency.format(total));

    }

}