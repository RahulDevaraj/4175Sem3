package com.example.sqlitedatabasedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyCoreDatabase extends SQLiteOpenHelper {

    static final String DB_NAME = "Education";
    static final String DB_TABLE = "students";
    static final int DB_VER= 1;

    Context context;
    SQLiteDatabase database;

    public MyCoreDatabase(Context context)
    {
        super(context,DB_NAME,null,DB_VER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table "+DB_TABLE+" (_id integer primary key autoincrement,stu_name text,college_name text);");
        Log.i("Database","table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+DB_TABLE);
        onCreate(sqLiteDatabase);

    }

    public void insertData(String s1,String s2)
    {
        database = getWritableDatabase();

        database.execSQL("insert into "+DB_TABLE+" (stu_name,college_name) values('"+s1+"','"+s2+"');");
        Toast.makeText(context, "Data saved Successfully", Toast.LENGTH_SHORT).show();
    }

    public void getAll(){
        database = getReadableDatabase();

        Cursor cursor=database.rawQuery("select * from "+DB_TABLE,null);

        StringBuilder stringBuilder = new StringBuilder();
        while(cursor.moveToNext()){
            String s1 = cursor.getString(1);
            String s2 = cursor.getString(2);
            stringBuilder.append(s1+"           "+s2+" \n");
        }

        Toast.makeText(context, stringBuilder.toString(), Toast.LENGTH_LONG).show();
    }

}
