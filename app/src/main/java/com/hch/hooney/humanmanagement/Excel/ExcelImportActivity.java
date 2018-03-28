package com.hch.hooney.humanmanagement.Excel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hch.hooney.humanmanagement.R;

public class ExcelImportActivity extends AppCompatActivity {
    private final String TAG = "ExcelImportActivity";

    private Button selectBTN;
    private TextView tempShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel_import);

        try{
            init();
        }catch (Exception e){
            Log.e(TAG, "Excel Import Activity Error...");
            e.printStackTrace();
        }
    }

    private void init() throws Exception{
        selectBTN = (Button) findViewById(R.id.excelImport_selectFile_BTN);
        tempShowList = (TextView) findViewById(R.id.excelImport_tempShow_list);

        setEvent();
    }

    private void setEvent() throws Exception{
        selectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
