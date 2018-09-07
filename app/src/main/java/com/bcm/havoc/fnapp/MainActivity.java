package com.bcm.havoc.fnapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RemoteViews;

import com.bcm.havoc.fnapp.Adapter.HomeAdapter;
import com.bcm.havoc.fnapp.Base.application.ACache;
import com.bcm.havoc.fnapp.Base.application.MyApplication;
import com.bcm.havoc.fnapp.Entity.BeekeePerEntity;
import com.bcm.havoc.fnapp.Entity.BeesInfoEntity;
import com.bcm.havoc.fnapp.Entity.FruitGrowersEntity;
import com.bcm.havoc.fnapp.Entity.FruitTreesInfoEntity;
import com.bcm.havoc.fnapp.Entity.OrderInfoEntity;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private View top;
    public static String intenttag1="main";
    private ArrayList<OrderInfoEntity> mDataList;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private Button openServer,closeServer;
    private MyApplication application;
    private ACache aCache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aCache = ACache.get(this);
        application = (MyApplication) getApplication();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
//        ImageView headicon = (ImageView)headerView.findViewById(R.id.headicon);
        ImageButton btn_out = (ImageButton)headerView.findViewById(R.id.btn_out);

        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BaseInfoActivity.class);
                intent.putExtra(BaseInfoActivity.intenttag2, "edit");
                startActivity(intent);
            }
        });
        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                application.out(MainActivity.this);
            }
        });
        initView();
        initData();
        initAdapter();
    }
    private void initView() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        LocationResult = (TextView) view.findViewById(R.id.textView1);
//        LocationResult.setMovementMethod(ScrollingMovementMethod.getInstance());
//        startLocation = (Button) view.findViewById(R.id.addfence);
        mRecyclerView = (RecyclerView)  findViewById(R.id.rv_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);
        openServer = top.findViewById(R.id.btn_open_server);
        closeServer = top.findViewById(R.id.btn_close_server);
        openServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openServer.setBackgroundResource(R.color.white);
                openServer.setTextColor(getResources().getColor(R.color.colorAccent));
                closeServer.setBackgroundResource(R.color.gray9);
                closeServer.setTextColor(getResources().getColor(R.color.graye));

            }
        });
        closeServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeServer.setBackgroundResource(R.color.white);
                closeServer.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                openServer.setBackgroundResource(R.color.gray9);
                openServer.setTextColor(getResources().getColor(R.color.graye));

            }
        });
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,OrderInfoEntity.class);
//                startActivity(intent);
            }
        });
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }
    private void refresh() {
      showDaiolg();
//        initData();
//        initView();
//        initAdapter();
        showRemoteView();
        mSwipeRefreshLayout.setRefreshing(false);

    }

    private void showDaiolg() {
        LayoutInflater  inflater = LayoutInflater.from(MainActivity.this);
        View  v = inflater.inflate(R.layout.view_notice, null);
        AlertDialog.Builder    dialog = new AlertDialog.Builder(MainActivity.this,R.style.MyAlertDialogLightStyle);
        dialog.setTitle("新的订单")
//        dialog.setBa(title);
                .setView(v)
                .setPositiveButton("了解详情...", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,OrderInfoActivity.class);
                        intent.putExtra(MainActivity.intenttag1, "new");
                        startActivity(intent);
                    }
                })  .create().show();
    }

    private void showRemoteView() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout_custom_notifycation);
        remoteViews.setImageViewResource(R.id.iv_icon, R.mipmap.ic_fn_com_logo2);
        remoteViews.setTextViewText(R.id.tv_title, "我是一个有内涵的程序猿");
        remoteViews.setTextViewText(R.id.tv_description, "你懂我的，作为新时代的程序员，要什么都会，上刀山下火海，背砖搬砖都要会，不然哈哈哈哈哈哈哈哈哈你就惨了");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this); builder.setSmallIcon(R.mipmap.ic_fn_com_logo2);
        builder.setContent(remoteViews);
        builder.setContentIntent(contentIntent);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            builder.setCustomBigContentView(remoteViews);
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService( Context.NOTIFICATION_SERVICE);
        notificationManager.notify(111, builder.build());
    }



    @SuppressWarnings("unchecked")
    private void initAdapter() {
        BaseQuickAdapter homeAdapter = new HomeAdapter( mDataList);
        homeAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN );//动画效果为缩放
//        动画默认只执行一次,如果想重复执行可设置
        homeAdapter.isFirstOnly(false);
        homeAdapter.addHeaderView(top);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this,OrderInfoActivity.class);
                if(position<1) {
                    intent.putExtra(MainActivity.intenttag1, "old");
                }
                else{
                    intent.putExtra(MainActivity.intenttag1, "over");
                }
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(homeAdapter);
    }

    private void initData() {
        //假数据
        mDataList = new ArrayList<>();
        List<String> photos = new ArrayList<>();
        photos.add("R.mipmap.im_beerx_1");
        photos.add("R.mipmap.im_beerx_2");
        photos.add("R.mipmap.im_beerx_3");
        BeesInfoEntity bees= new BeesInfoEntity("1","熊蜂",photos,"2500");
        List<BeesInfoEntity> beerlist = new ArrayList<>();
        beerlist.add(bees);
        BeekeePerEntity bentity = new BeekeePerEntity("", "张卫华", "昌平益达丰果蔬农场", "北京市昌平区南口镇", "12",
                "18651002639", "http://cpfyxh.cpweb.gov.cn/", "35000", "12",
                "1", "65", "2", "20000", "200", beerlist);

        List<FruitTreesInfoEntity> fruitTreesInfoEntityList = new ArrayList<>();
        FruitGrowersEntity fentity = new FruitGrowersEntity("","","","","","","","",fruitTreesInfoEntityList );
        for(int i=0;i<11;i++) {
            String   status ="已完成";
            if(i==0){
                status ="未完成";
            }
            OrderInfoEntity orderInfoEntity = new OrderInfoEntity(fentity,bentity,status);

            mDataList.add(orderInfoEntity);
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
//       View view=getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(MainActivity.this,MapsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
