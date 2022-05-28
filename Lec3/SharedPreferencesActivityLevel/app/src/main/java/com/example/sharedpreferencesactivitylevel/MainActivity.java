package com.example.sharedpreferencesactivitylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName,editTextMajor,editTextID;
    private TextView textViewName,textViewMajor,textViewID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextID = findViewById(R.id.editTextId);
        editTextMajor = findViewById(R.id.editTextMajor);

        textViewID = findViewById(R.id.textViewID);
        textViewName = findViewById(R.id.textViewName);
        textViewMajor = findViewById(R.id.textViewMajor);


    }

    public void loadData(View view) {

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        String name= sharedPreferences.getString("name","Name is not available");
        String major= sharedPreferences.getString("major","Major is not available");
        String id= sharedPreferences.getString("Id","Id is not available");

        textViewName.setText(name);
        textViewMajor.setText(major);
        textViewID.setText(id);

    }

    public void saveData(View view) {

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //now save the data

        editor.putString("name",editTextName.getText().toString());
        editor.putString("major",editTextMajor.getText().toString());
        editor.putString("Id",editTextID.getText().toString());

        editor.apply(); //editor.commit();
        /*
        commit saves async and apply() saves sync
         */
    }
}