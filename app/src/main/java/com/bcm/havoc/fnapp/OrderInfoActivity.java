package com.bcm.havoc.fnapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class OrderInfoActivity extends AppCompatActivity {
private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);

        back = (ImageButton) findViewById(R.id.im_back_order);
        back.setOnClickListener(new View.OnClickListener() {
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
}
