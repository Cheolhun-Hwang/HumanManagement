package com.hch.hooney.humanmanagement.Excel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hch.hooney.humanmanagement.R;

public class ExcelActivity extends AppCompatActivity {
    private final String TAG = "ExcelActivity";

    private Button tab1, tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel);

        try{
            init();
        }catch (Exception e){
            Log.e(TAG, "Excel Activity Error...");
            e.printStackTrace();
        }
    }

    private void init() throws Exception{
        tab1 = (Button) findViewById(R.id.excelImportBTN);
        tab2 = (Button) findViewById(R.id.excelExportBTN);

        setEvent();
    }

    private void setEvent() throws Exception{
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcelActivity.this, ExcelImportActivity.class));
            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExcelActivity.this, ExcelExportActivity.class));
            }
        });
    }
}
