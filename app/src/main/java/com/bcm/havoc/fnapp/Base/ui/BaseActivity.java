package com.bcm.havoc.fnapp.Base.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bcm.havoc.fnapp.Base.utils.logger.Logger;
import com.bcm.havoc.fnapp.R;


/**
 * 文 件 名: BaseActivity
 * 创 建 人: Allen
 * 创建日期: 16/12/24 15:33
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class BaseActivity extends AppCompatActivity {
    /**
     * 日志输出标志getSupportActionBar().
     **/
    private TextView title;
    private ImageView back;
    protected final String TAG = this.getClass().getSimpleName();

    protected void setTitle(String msg) {
        if (title != null) {
            title.setText(msg);
        }
    }

    /**
     * sometime you want to define back event
     */
    protected void setBackBtn() {
        if (back != null) {
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else {
            Logger.t(TAG).e("back is null ,please check out");
        }

    }

    protected void setBackClickListener(View.OnClickListener l) {
        if (back != null) {
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(l);
        }else {
            Logger.t(TAG).e("back is null ,please check out");
        }

    }

    private LinearLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 经测试在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        // 这句很关键，注意是调用父类的方法
        super.setContentView(R.layout.activity_base);
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        if (getSupportActionBar() != null) {
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }
        back = (ImageView) findViewById(R.id.img_back);
        title = (TextView) findViewById(R.id.title);
    }


    @Override
    public void setContentView(int layoutId) {
        setContentView(View.inflate(this, layoutId, null));
    }

    @Override
    public void setContentView(View view) {
        rootLayout = (LinearLayout) findViewById(R.id.root_layout);
        if (rootLayout == null) return;
        rootLayout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        initToolbar();
    }
}

//import static com.bcm.havoc.wmapp.Base.DB.XDBManager.db;
//        import static com.bcm.havoc.wmapp.Base.DB.XDBManager.initDb;
//
//public class RkListActivity extends BaseActivity {
//    private RecyclerView mRecyclerView;
//    private BaseQuickAdapter adapter;
//    private List<Stock_IN>  mDataList;
//    private SwipeRefreshLayout mSwipeRefreshLayout;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rk_list);
//        initDb();
//        initData();
//        initView();
//        initAdapter();
//    }
//
//    private void initData() {
//        try {
//            mDataList = db.selector(Stock_IN.class).where("State","<",5).findAll();
//        } catch (DbException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void initView() {
//        setTitle("入库任务");
//        setBackBtn();
//        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
//        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
//        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                refresh();
//            }
//        });
//
//    }
//
//    private void refresh() {
//        initData();
//        initView();
//        initAdapter();
//        mSwipeRefreshLayout.setRefreshing(false);
//
//    }
//
//    private void initAdapter() {
//        adapter= new MyAdapter(mDataList);
//        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN );//动画效果为缩放
////        动画默认只执行一次,如果想重复执行可设置
//        adapter.isFirstOnly(false);
////        adapter.addHeaderView(top);
//        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Intent intent = new Intent(RkListActivity.this, RkActivity.class);
//                intent.putExtra(RkActivity.intenttagrk, mDataList.get(position));
//                startActivity(intent);
//            }
//        });
//
//        mRecyclerView.setAdapter(adapter);
//    }
//
//    public class MyAdapter extends BaseQuickAdapter<Stock_IN, BaseViewHolder> {
//        public MyAdapter(List data) {
//            super(R.layout.item_text_view,data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, Stock_IN item) {
////        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.tweetName);
//
//            helper.setText(R.id.tv_supplier_name, item.getSupplierName());
//            helper.setText(R.id.tv_rk_no, item.getInNumber());
//            helper.setText(R.id.tv_ck_no, item.getCangKuId());
//            helper.setText(R.id.tv_rk_time, item.getStrInTime());
//
//
//            List<Stock_IN_Detail> stock_in_detail_list = new ArrayList<>();
//            try {
//                stock_in_detail_list = db.selector(Stock_IN_Detail.class).where("InNumber","=",item.getInNumber()).findAll();
//
//
//            } catch (DbException e) {
//                e.printStackTrace();
//            }
//            helper.setText(R.id.tv_item_num,stock_in_detail_list.size()+"");
//
//
//        }
//
//
//    }
//@Override
//public void onClick(View view) {
//    switch (view.getId()) {
//        case R.id.tv_new_start_time:
//
//            break;
//        case R.id.tv_new_end_time:
//
//            break;
//        case R.id.tv_new_furit_kind:
//
//            break;
////            case R.id.tv_new_area:
////                finish();
////                break;
////               default:
//                break;
//
//    }
//
//}
//    @Override
//    protected void onResume() {
//        refresh();
//        super.onResume();
//    }
//}
