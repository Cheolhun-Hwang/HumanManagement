package com.hch.hooney.humanmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hch.hooney.humanmanagement.Excel.ExcelActivity;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    private Button tab1, tab2, tab3, tab4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            init();
        }catch (Exception e){
            Log.e(TAG, "Main Activity Error...");
            e.printStackTrace();
        }

    }

    private void init() throws Exception{
        tab1 = (Button) findViewById(R.id.main_tab1);
        tab2 = (Button) findViewById(R.id.main_tab2);
        tab3 = (Button) findViewById(R.id.main_tab3);
        tab4 = (Button) findViewById(R.id.main_tab4);
        setEvent();
    }

    private void setEvent() throws Exception{
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExcelActivity.class));
            }
        });
        tab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
