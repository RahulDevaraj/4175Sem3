package com.example.sqlitedatabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,college;
    MyCoreDatabase myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edit1);
        college = findViewById(R.id.edit2);
        myData = new MyCoreDatabase(this);
    }

    public void doSave(View view) {
        Log.i("TAG",""+name.getText().toString()+" "+college.getText().toString());
        myData.insertData(name.getText().toString(),college.getText().toString());
    }

    public void doLoad(View view) {
        myData.getAll();
    }
}