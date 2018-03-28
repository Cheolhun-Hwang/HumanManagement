package com.hch.hooney.humanmanagement;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hch.hooney.humanmanagement.DAO.DAO;

import java.io.File;

public class LoadingActivity extends AppCompatActivity {
    private final String TAG = "LoadingActivity";
    private final int SIGNAL_PERMISSION = 1001;
    //private static final String FILENAME = "imports.xlsx";
    private static final String DNAME = "HumanManagement";

    private Thread loadingThread;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        try{
            init();
        }catch (Exception e){
            Log.e(TAG, "Loading Activity Error...");
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        clearThread();
        loadingThread = initLoadingThread();
        loadingThread.start();
    }

    @Override
    protected void onStop() {
       clearThread();
       super.onStop();
    }

    private void init() throws Exception{

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what){
                    case 10001:
                        checkDangerousPermissions();
                        break;
                    default:
                        break;
                }

                return true;
            }
        });


        setEvent();
    }

    private void setEvent() throws Exception{

    }

    private Thread initLoadingThread(){
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    DAO.initStaticDAOResources(getApplicationContext());
                    createDirectory();
                    Thread.sleep(1500);
                    Message msg = handler.obtainMessage();
                    msg.what = 10001;
                    handler.sendMessage(msg);
                }catch (Exception e){
                    Log.e(TAG, "Loading Thread Error...");
                    e.printStackTrace();
                }
            }
        });
    }

    private void intentMain(){
        startActivity(new Intent(LoadingActivity.this, MainActivity.class));
        finish();
    }

    private void clearThread(){
        if(loadingThread != null){
            if(loadingThread.isAlive()){
                loadingThread.interrupt();
            }

            if(loadingThread.isInterrupted()){
                loadingThread = null;
            }

            loadingThread = null;
        }
    }

    private void createDirectory(){
        File rootPath = new File(Environment.getExternalStorageDirectory(), DNAME);
        if(!rootPath.exists()) {
            rootPath.mkdirs();
        }
    }
    /* 사용자 권한 확인 메서드
           - import android.Manifest; 를 시킬 것
         */
    private void checkDangerousPermissions() {
        String[] permissions = {//import android.Manifest;
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };

        //권한을 가지고 있는지 체크
        boolean isall = true;
        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(LoadingActivity.this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                isall = false;
                break;
            }
        }

        if (isall) {
            Log.d(TAG, "권한있음");
            intentMain();
        } else {
            Log.d(TAG, "권한없음");

            ActivityCompat.requestPermissions(LoadingActivity.this, permissions, SIGNAL_PERMISSION);
        }
    }//end of checkDangerousPermissions



    // 사용자의 권한 확인 후 사용자의 권한에 대한 응답 결과를 확인하는 콜백 메소드
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == SIGNAL_PERMISSION) {
            boolean isall = true;
            for(int temp : grantResults){
                if(temp == PackageManager.PERMISSION_DENIED){
                    isall = false;
                }
            }

            if(isall){
                intentMain();
            }else{
                checkDangerousPermissions();
                Toast.makeText(getApplicationContext(),
                        "모든 권한이 반드시 필요합니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }//end of onRequestPermissionsResult


}
