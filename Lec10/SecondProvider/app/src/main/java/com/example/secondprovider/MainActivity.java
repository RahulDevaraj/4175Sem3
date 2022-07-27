package com.example.secondprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Uri CONTENT_URI=Uri.parse("content://com.rahul.my.company.provider/emp");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadData(View view) {

        @SuppressLint("Recycle")
        Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, "_id");
        if (cursor == null) {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String s1 = cursor.getString(1);
                String s2 = cursor.getString(2);
                stringBuilder.append(id + " " + s1 + " " + s2 + "\n");

            }

            Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
            cursor.close();
        }

    }
}