package com.hch.hooney.humanmanagement.Excel;

import android.location.Address;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hch.hooney.humanmanagement.DAO.HumanManagement;
import com.hch.hooney.humanmanagement.R;
import com.hch.hooney.humanmanagement.ResourceCTRL.AddressToGPS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelImportActivity extends AppCompatActivity {
    private final String TAG = "ExcelImportActivity";
    private static final String FILENAME = "imports.xls";
    private static final String DNAME = "HumanManagement";

    private Button selectBTN;
    private TextView tempShowList;

    private String nowDate;

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

    private void readInitFile() throws FileNotFoundException, IOException, BiffException {
        File rootPath = new File(Environment.getExternalStorageDirectory(), DNAME);
        if(!rootPath.exists()) {
            rootPath.mkdirs();
        }

        File dataFile = new File(rootPath, FILENAME);
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "Cannot use storage.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }else{
            //File Write;
//            FileOutputStream mOutput = new FileOutputStream(dataFile, false);
//            String data = "DATA";
//            mOutput.write(data.getBytes());
//            mOutput.close();

            //File Read;
            FileInputStream mInput = new FileInputStream(dataFile);
            //Excel
            Workbook wb = Workbook.getWorkbook(mInput);
            Sheet sheet = wb.getSheet(0);
            int row = sheet.getRows();
            int col = sheet.getColumns();

            Date tempDate = new Date();


            for(int r = 0 ; r < row;r++){
                HumanManagement item = new HumanManagement();
                for(int c = 0 ; c < col ; c++){
                    Cell cell = sheet.getCell(c, r);
                    if(cell.getContents().equals("이름")){
                        continue;
                    }else{
                        switch (c){
                            case 0:
                                //이름
                                item.setIsNew(0); //No
                                item.setHm_name(cell.getContents());
                                break;
                            case 1:
                                //직급
                                item.setHm_part(cell.getContents());
                                break;
                            case 2:
                                //전화번호
                                item.setHm_phone(cell.getContents());
                                break;
                            case 3:
                                //주소
                                item.setHm_address(cell.getContents());
                                Address tempAddress = AddressToGPS.getAddress(getApplicationContext(),
                                        cell.getContents());
                                if(tempAddress == null){
                                    item.setHm_mapX(0.0);
                                    item.setHm_mapY(0.0);
                                }else{
                                    item.setHm_mapX(tempAddress.getLongitude());
                                    item.setHm_mapY(tempAddress.getLatitude());
                                }
                                break;
                            case 4:
                                //장소명
                                item.setHm_spotName(cell.getContents());
                                break;
                            case 5:
                                //메모
                                item.setHm_comment(cell.getContents());
                                break;
                            default:
                                break;
                        }
                    }

                }
            }
//            byte[] data = new byte[128];
//            mInput.read(data);
            mInput.close();

//            String display = new String(data);
//            tempShowList.setText(display.trim());
        }
    }

    private void setEvent() throws Exception{
        selectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isExternalStorageAvailable() || isExternalStorageReadOnly()){
                    Toast.makeText(getApplicationContext(),
                            "읽을 수 있는 저장공간이 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    try {
                        readInitFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (BiffException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
