package com.example.work7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //查询数据
                Uri uri = Uri.parse("content://com.example.work7_1.provider/contacts");
                Cursor cursor = getContentResolver().query(uri,null,null,null,null);
                if (cursor!=null){
                    while (cursor.moveToNext()){
                        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                        @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex("phone"));
                        @SuppressLint("Range") String sex = cursor.getString(cursor.getColumnIndex("sex"));
                        Log.d("MainActivity","name is"+name);
                        Log.d("MainActivity","phone is"+phone);
                        Log.d("MainActivity","sex is"+sex);
                    }
                    cursor.close();
                }
            }
        });
    }
}