package com.bcm.havoc.fnapp.Base.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.bcm.havoc.fnapp.Base.application.ACache;
import com.bcm.havoc.fnapp.Base.application.MyApplication;
import com.bcm.havoc.fnapp.R;
import com.google.gson.Gson;

import org.xutils.DbManager;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

import java.util.ArrayList;

//import com.bcm.havoc.warehousemanagement.DB.SQLiteHelper;

@ContentView(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    private Context context = LoginActivity.this;
    private String USER,PASSWORD;
    //public static String URL="http://123.57.29.113:8080/MVNFHM/appInterface";
    private ACache aCache;
    private Gson gson= new Gson();
    //"http://172.16.10.242:8080/bcm_rz/appInterface/appLogin";
    private SharedPreferences sharedPrefs;
    private  DbManager db;
    private final int SDK_PERMISSION_REQUEST = 127;
    private String permissionInfo;
    EditText etUrl,et_User, et_Password;
    Button btn_Login;
    private MyApplication application;
    private   ProgressDialog progressDialog;

//    private SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(TAG,"LoginActivity登陆");
        x.view().inject(this);
//        sqLiteHelper = SQLiteHelper.getInstance(this);
        application = (MyApplication) getApplication();
        aCache = ACache.get(this);
        //et_Comm=(EditText)findViewById(R.id.et_comm);
        et_User=(EditText)findViewById(R.id.et_user);
        et_Password=(EditText)findViewById(R.id.et_pass);
        btn_Login=(Button)findViewById(R.id.btn_login);
        getPersimmions();

    }

    /**
     * 单击事件
     * type默认View.OnClickListener.class，故此处可以简化不写，@Event(R.id.bt_main)
     */
    @Event(type = View.OnClickListener.class,value = R.id.btn_login)
    private void testInjectOnClick(View v){
//        Url =
        USER = et_User.getText().toString();
        PASSWORD = et_Password.getText().toString();
        LoginHttp(USER,PASSWORD);
//            Snackbar.make(v,"OnClickListener",Snackbar.LENGTH_SHORT).show();
    }
    /**
     * 长按事件
     @Event(type = View.OnLongClickListener.class,value = R.id.bt_main)
    private boolean testOnLongClickListener(View v){
        Snackbar.make(v,"testOnLongClickListener",Snackbar.LENGTH_SHORT).show();
        return true;
    }
     */
    private void LoginHttp(String acc,String password) {

//
//        RequestParams params = new RequestParams(URLConfig.LoginIn);
////        params.addBodyParameter("Phone",et_User.getText().toString());
////        params.addParameter("PassWord",et_Password.getText().toString());
//        progressDialog = new ProgressDialog(this);
//        LoginRequest bean = new LoginRequest(et_User.getText().toString(),et_Password.getText().toString());
//        Logger.i(et_User.getText().toString()+et_Password.getText().toString());
//        String RequestStr = gson.toJson(bean);
//        params.setAsJsonContent(true);
//        params.setBodyContent(RequestStr);
//        params.setCharset("UTF-8");
//        Log.i(TAG,"params="+params+RequestStr);
//        x.http().post(params, new Callback.ProgressCallback<String>() {
//            @Override
//            public void onWaiting() {
//
//            }
//
//            @Override
//            public void onStarted() {
//
//            }
//
//            @Override
//            public void onLoading(long total, long current, boolean isDownloading) {
//                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//                progressDialog.setMessage("正在加载数据，请稍等。。。");
//                progressDialog.show();
//                progressDialog.setMax((int) total);
//                progressDialog.setProgress((int) current);
//            }
//
//            @Override
//            public void onSuccess(String result) {
//
//                     Logger.d(result);
//                    SectionEntity.ServiceEntity<SystemUsers> Entity = JsonUtils.getServiceEntity(result, SystemUsers.class);
//                          Logger.i("getMsg:"+Entity.getMsg()+"");
//                    if (Entity.getStatus().equals("200")) {
//                        //写缓存
//                        application.setUserLoginMainEntity(Entity.getData());
//                        aCache.put(MyApplication.userinfo, Entity.getData());
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        Logger.d(Entity.getData());
//                        startActivity(intent);
////                        Toast.makeText(LoginActivity.this,"LoginActivity",Toast.LENGTH_SHORT);
//                    }
//                    else {
//                        et_User.setText("");
//                        et_Password.setText("");
//                        Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
//                    }
//                progressDialog.dismiss();
//            }
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                ex.printStackTrace();
//                Toast.makeText(LoginActivity.this, "下载失败，请检查网络和SD卡", Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();
//            }
//            @Override
//            public void onCancelled(CancelledException cex) {
//            }
//            @Override
//            public void onFinished() {
//            }
//        });

    }
    @TargetApi(19)
    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
    @TargetApi(23)
    private void getPersimmions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            /***
             * 定位权限为必须权限，用户如果禁止，则每次进入都会申请
             */
            // 定位精确位置
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
			/*
			 * 读写权限和电话状态权限非必要权限(建议授予)只会申请一次，用户同意或者禁止，只会弹一次
			 */
            // 读写权限
            if (addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissionInfo += "Manifest.permission.WRITE_EXTERNAL_STORAGE Deny \n";
            }
            // 读取电话状态权限
            if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
                permissionInfo += "Manifest.permission.READ_PHONE_STATE Deny \n";
            }

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

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // TODO Auto-generated method stub
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}

