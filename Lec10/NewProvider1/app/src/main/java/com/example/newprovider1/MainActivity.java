package com.example.newprovider1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;

    ContentValues values=new ContentValues();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.edit2);


    }

    public void saveContent(View view) {
        values.put("emp_name",e1.getText().toString());
        values.put("profile",e2.getText().toString());

        Uri uri=getContentResolver().insert(CompanyProvider.CONTENT_URI,values);
        Toast.makeText(this, uri.toString(), Toast.LENGTH_SHORT).show();
    }

    public void loadContent(View view) {
        Cursor cursor = getContentResolver().query(CompanyProvider.CONTENT_URI,null,null,null,"_id");
       StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext())
        {
            int id=cursor.getInt(0);
            String s1=cursor.getString(1);
            String s2=cursor.getString(2);
            stringBuilder.append(id+" "+s1+" "+s2+"\n");

        }

        Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
        cursor.close();
    }



}