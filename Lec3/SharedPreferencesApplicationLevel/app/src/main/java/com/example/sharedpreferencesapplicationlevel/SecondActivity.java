package com.example.sharedpreferencesapplicationlevel;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewName,textViewMajor,textViewID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewID = findViewById(R.id.textViewID2);
        textViewName = findViewById(R.id.textViewName2);
        textViewMajor = findViewById(R.id.textViewMajor2);
    }

    public void clearData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void removeStudentMajor(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("major");
        editor.apply();
    }

    public void loadData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file",MODE_PRIVATE);

        String name= sharedPreferences.getString("name","Name is not available");
        String major= sharedPreferences.getString("major","Major is not available");
        String id= sharedPreferences.getString("Id","Id is not available");

        textViewName.setText(name);
        textViewMajor.setText(major);
        textViewID.setText(id);
    }
}
