package com.example.venkatanish.got;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button view;




    DataBaseHelper dd=new DataBaseHelper(this);





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dd.inserthouses("Lannister","Lion","Cersei","King's Landing");



        final Button view = (Button) findViewById(R.id.button3);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dd.insertdata("Lannister".toString(),"Lion".toString(),"Cersei".toString(), "King's Landing".toString());

                Cursor res = dd.getAllData();

            }
        });

    }




}
