package com.bcm.havoc.fnapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bcm.havoc.fnapp.Base.ui.BaseActivity;
import com.bcm.havoc.fnapp.Base.utils.DateDialog;
import com.bcm.havoc.fnapp.Base.utils.TimeUtils;
import com.jaygoo.widget.RangeSeekBar;

public class NewActivity extends BaseActivity implements View.OnClickListener {
    private TextView startTime, endTime, furitkind, beerkind;
    private DateDialog dateDialog;
    private String[] furitkindlist,beerkindlist;
    private RangeSeekBar seekbar5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        initData();
        initView();
    }

    private void initData() {
    }

    private void initView() {
        setTitle("新建订单");
        setBackBtn();
        dateDialog = new DateDialog(this);
//        KeyBoardUtil.getInstance(NewActivity.this).hide();
        startTime = (TextView) findViewById(R.id.tv_new_start_time);
        endTime = (TextView) findViewById(R.id.tv_new_end_time);
        furitkind = (TextView) findViewById(R.id.tv_new_furit_kind);
        beerkind = (TextView) findViewById(R.id.tv_new_beer_kind);
//        seekbar5 = findViewById(R.id.seekbar5);
//        seekbar5.setValue(25, 75);
        findViewById(R.id.tv_new_start_time).setOnClickListener(this);
        findViewById(R.id.tv_new_end_time).setOnClickListener(this);
        findViewById(R.id.tv_new_furit_kind).setOnClickListener(this);
//        findViewById(R.id.tv_new_area).setOnClickListener(this);
//        findViewById(R.id.tv_new_beer_num).setOnClickListener(this);
        findViewById(R.id.tv_new_beer_kind).setOnClickListener(this);
        findViewById(R.id.tv_new_message).setOnClickListener(this);
        findViewById(R.id.btn_miss_fn).setOnClickListener(this);
        furitkindlist = new String[6];
        furitkindlist[0] = "番茄";
        furitkindlist[1] = "西瓜";
        furitkindlist[2] = "丝瓜";
        furitkindlist[3] = "西红柿";
        furitkindlist[4] = "辣椒";
        furitkindlist[5] = "冬瓜";
        beerkindlist = new String[9];
        beerkindlist[0] = "大熊蜂";
        beerkindlist[1] = "黑小蜜蜂";
        beerkindlist[2] = "黑大蜜蜂";
        beerkindlist[3] = "大蜜蜂";
        beerkindlist[4] = "沙巴蜂";
        beerkindlist[5] = "西方蜜蜂";
        beerkindlist[6] = "绿努蜂";
        beerkindlist[7] = "苏拉威西蜂";
        beerkindlist[8] = "东方蜜蜂";
//        seekbar5.setOnRangeChangedListener(new OnRangeChangedListener() {
//            @Override
//            public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue, boolean isFromUser) {
//                seekbar5.setIndicatorText((int) leftValue + "");
////                application.setCachedate((int)leftValue);
//            }
//
//            @Override
//            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {
//                //do what you want!!
//            }
//
//            @Override
//            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {
//                //do what you want!!
//            }
//        });
////        if (application.getCachedate() != 0) {
////            seekbar5.setValue(application.getCachedate());
////        } else {
////            seekbar5.setValue(30);
////        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_new_start_time:
                dateDialog.setting(startTime, TimeUtils.getCurrentTimeInString(), null);
                break;
            case R.id.tv_new_end_time:
                if (startTime.getText().toString().length() > 0) {
                    dateDialog.setting(endTime, startTime.getText().toString(), null);
                } else {
                    dateDialog.setting(startTime, TimeUtils.getCurrentTimeInString(), null);
                }
                break;
            case R.id.tv_new_furit_kind:
                dateDialog.setList("果树种类", furitkind, furitkindlist);
                break;
//            case R.id.tv_new_area:
//                finish();
//                break;
//            case R.id.tv_new_beer_num:
//                finish();
//                break;
            case R.id.tv_new_beer_kind:
                dateDialog.setList("蜜蜂种类", beerkind, beerkindlist);
                break;
            case R.id.tv_new_message:
                finish();
                break;
            case R.id.btn_miss_fn:
                Intent intent = new Intent(NewActivity.this,MapsActivity.class);
                startActivity(intent);
                break;

        }

    }
}
