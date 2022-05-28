package com.example.sharedpreferencesapplicationlevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName,editTextMajor,editTextID;
    private TextView textViewName,textViewMajor,textViewID;
    private Switch pageColorSwitch;
    private LinearLayout pageLayout;

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

        pageLayout = findViewById(R.id.pageLayout);

        pageColorSwitch = findViewById(R.id.switchPageColor);

        pageColorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                setPageColor(isChecked);

            }


        });

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        boolean isChecked = sharedPreferences.getBoolean("yellow",false);
        pageColorSwitch.setChecked(isChecked);


    }

    private void setPageColor(boolean isChecked) {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("yellow",isChecked);
        editor.apply();

        pageLayout.setBackgroundColor(isChecked? Color.YELLOW:Color.WHITE);
    }

    public void loadData(View view) {

       // SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file",MODE_PRIVATE);

        String name= sharedPreferences.getString("name","Name is not available");
        String major= sharedPreferences.getString("major","Major is not available");
        String id= sharedPreferences.getString("Id","Id is not available");

        textViewName.setText(name);
        textViewMajor.setText(major);
        textViewID.setText(id);

    }

    public void saveData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file",MODE_PRIVATE);

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

    public void openSecondActivity(View view) {

        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}