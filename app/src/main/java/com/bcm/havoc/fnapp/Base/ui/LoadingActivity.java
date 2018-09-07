package com.bcm.havoc.fnapp.Base.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.bcm.havoc.fnapp.Base.application.MyApplication;
import com.bcm.havoc.fnapp.MainActivity;
import com.bcm.havoc.fnapp.R;

import java.util.ArrayList;

public class LoadingActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    private String TAG = this.getClass().getSimpleName();
    private static final int TIME = 3000;
    private static final int GO_HOME = 15000;
    private static final int GO_MAIN = 15001;
//    private boolean isFirstIn = false;
    private final int SDK_PERMISSION_REQUEST = 127;
    private String permissionInfo;
    private MyApplication application;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case GO_HOME:
                    goHome();
//                    goMain();
                    finish();
                    break;
                case GO_MAIN:
                    goMain();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        initWindow();
        application = (MyApplication) getApplication();
        getPersimmions();
        if (Build.VERSION.SDK_INT >= 23) {
            checkPermission();
        }
        if( application.getUserLoginMainEntity() == null) {
            handler.sendEmptyMessageDelayed(GO_HOME, TIME);
        }
        else {
           handler.sendEmptyMessageDelayed(GO_MAIN, TIME);
        }

    }

    @TargetApi(19)
    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    private void goHome(){
        Log.i("LoadingActivity","LoadingActivity欢迎。。。Intent");
        Intent intent = new Intent(LoadingActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private void goMain(){
        Log.i("LoadingActivity","LoadingActivity欢迎。。。Intent");
        Intent intent = new Intent(LoadingActivity.this,MainActivity.class);
//         Intent intent = new Intent(LoadingActivity.this,ScanActivity.class);
        startActivity(intent);
        finish();
    }

    @TargetApi(23)
    private void getPersimmions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            /***
             * 定位权限为必须权限，用户如果禁止，则每次进入都会申请
             */
            // 定位精确位置
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.CAMERA);
            }
            if(checkSelfPermission(Manifest.permission.WRITE_SETTINGS) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.WRITE_SETTINGS);
            }


			/*
			 * 读写权限和电话状态权限非必要权限(建议授予)只会申请一次，用户同意或者禁止，只会弹一次
			 */
            // 读写权限
            if (addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissionInfo += "Manifest.permission.WRITE_EXTERNAL_STORAGE Deny \n";
            }
            // 读取电话状态权限
//            if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
//                permissionInfo += "Manifest.permission.READ_PHONE_STATE Deny \n";
//            }

            if (permissions.size() > 0) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
            }
        }
    }

    @TargetApi(23)
    private boolean addPermission(ArrayList<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) { // 如果应用没有获得对应权限,则添加到列表中,准备批量申请
            if (shouldShowRequestPermissionRationale(permission)){
                return true;
            }else{
                permissionsList.add(permission);
                return false;
            }

        }else{
            return true;
        }
    }

    //6.0以上才能调用
    @TargetApi(23)
    void checkPermission(){
        if(!Settings.System.canWrite(this)){
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

}
