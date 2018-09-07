package com.bcm.havoc.fnapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class OrderInfoActivity extends AppCompatActivity {
private ImageButton back;
private TextView tv_status,tv_phone;
private Button btn_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);
        initWindow();
        Intent intent = getIntent();
        String str = intent.getStringExtra(MainActivity.intenttag1);

        back = (ImageButton) findViewById(R.id.im_back_order);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_status = (TextView)findViewById(R.id.tv_oder_status);
        tv_phone = (TextView)findViewById(R.id.tv_oder_phone);
        tv_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cellTel();
            }
        });
        if(str.equals("new")){
            tv_status.setText("未接单");
        }
        else if(str.equals("old")){
            tv_status.setText("未完成");
        }
        else {
            tv_status.setText("已完成");
        }
        btn_ok = (Button) findViewById(R.id.im_new_order_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
//        initView();
//        initData();
//        initAdapter();
    }

    private void initAdapter() {

    }

    private void initData() {

    }

    private void initView() {
//        setTitle("订单信息");
//        setBackBtn();

    }
    @TargetApi(19)
    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
    //拨打电话
        private void cellTel() {
            //激活可以打电话的组件
            String phone = tv_phone.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
            startActivity(intent);
        }
}
