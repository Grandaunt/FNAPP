package com.bcm.havoc.fnapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.bcm.havoc.fnapp.Base.ui.BaseActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaygoo.widget.RangeSeekBar;

import java.util.ArrayList;
import java.util.List;

public class BaseInfoActivity extends BaseActivity implements View.OnClickListener{
    public static String intenttag2="BaseInfo";
    private RecyclerView mRecyclerView;
        private BaseQuickAdapter adapter;
        private Button btn_miss_fn;
        private  String str;
    private RangeSeekBar seekbar1,seekbar2,seekbar3;
        private List<String>  mDataList;
//    private SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_info);

//        initWindow();
        initData();
        initView();
//        initAdapter();
    }

    private void initData() {
        mDataList=new ArrayList<>();
        mDataList.add("1");
        mDataList.add("1");
    }

    private void initView() {
        Intent intent = getIntent();
         str = intent.getStringExtra(BaseInfoActivity.intenttag2);
        if(str.equals("registered")){
            setTitle("注册");
        }
        else if(str.equals("edit")){
            setTitle("编辑个人信息");
        }
        setBackBtn();
      findViewById(R.id.btn_miss_fn).setOnClickListener(this);
        seekbar1 = findViewById(R.id.seekbar1);
        seekbar1.setValue(0, 100);
        seekbar2 = findViewById(R.id.seekbar2);
        seekbar2.setValue(0, 100);
        seekbar3 = findViewById(R.id.seekbar3);
        seekbar3.setValue(0, 100);
//        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));

    }

    @TargetApi(19)
    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

//    private void initAdapter() {
//        adapter= new MyAdapter(mDataList);
//        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN );//动画效果为缩放
////        动画默认只执行一次,如果想重复执行可设置
//        adapter.isFirstOnly(false);
////        adapter.addHeaderView(top);
//        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//
//            }
//        });
//
//        mRecyclerView.setAdapter(adapter);
//    }
//    public class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
//                public MyAdapter(List data) {
//            super(R.layout.item_teixt_view,data);
//        }

//        @Override
//        protected void convert(BaseViewHolder helper, String item) {
////        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.tweetName);
//
//
//
//
//        }
//
//
//    }
@Override
public void onClick(View view) {
    switch (view.getId()) {
        case R.id.btn_miss_fn:
            if(str.equals("registered")){
                Intent intent = new Intent(BaseInfoActivity.this,MainActivity.class);
                startActivity(intent);
            }
            else if(str.equals("edit")){
               finish();
            }
            Toast.makeText(BaseInfoActivity.this, "信息保存成功", Toast.LENGTH_SHORT).show();

            break;
//        case R.id.tv_new_end_time:
//
//            break;
//        case R.id.tv_new_furit_kind:
//
//            break;
//            case R.id.tv_new_area:
//                finish();
//                break;
//               default:
//                break;

    }

}
    @Override
    protected void onResume() {

        super.onResume();
    }
}
