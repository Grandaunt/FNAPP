package com.bcm.havoc.fnapp.Base.application;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.ImageView;

import com.baidu.mapapi.SDKInitializer;
import com.bcm.havoc.fnapp.Base.entity.UserEntity;
import com.bcm.havoc.fnapp.Base.service.LocationService;
import com.bcm.havoc.fnapp.Base.ui.LoginActivity;
import com.bcm.havoc.fnapp.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;




/**
 * MyApplication
 */
public class MyApplication extends Application {
    private static MyApplication instance;
    public LocationService locationService;
    public Vibrator mVibrator;
    public static final String userinfo = "userinfo";
    public final static String SCAN_ACTION = "scan.rcv.message";
    private String userid;
    public String url;

    private UserEntity userLoginMainEntity;
    private ACache aCache;
    //    public DisplayImageOptions options;
    private ArrayList<Activity> activityList = new ArrayList<Activity>();
    public static ImageOptions optionCricle,imageOptions;
    public static String PLANID ="";
    //    private String userImage;
//    public static ScanDevice smD;
    public static boolean IsOnResumePtr = false;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true); // 是否输出debug日志
        instance = this;
//        initRxGallery();
        initACache();

        //头像
        optionCricle = new ImageOptions.Builder()
                //设置圆形
                .setCircular(true)
                //设置加载过程中的图片
                .setLoadingDrawableId(R.mipmap.ic_launcher_round)
//设置加载失败后的图片
                .setFailureDrawableId(R.mipmap.ic_launcher_round)
                //某些手机拍照时图片自动旋转，设置图片是否自动旋转为正
                .setAutoRotate(true)
                //等比例缩放居中显示
                .setImageScaleType(ImageView.ScaleType.CENTER)
                .build();
        imageOptions = new ImageOptions.Builder()

                //某些手机拍照时图片自动旋转，设置图片是否自动旋转为正
                .setAutoRotate(true)
                //等比例缩放居中显示
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .build();

        //打开日志
//        ModelUtils.setDebugModel(true);

//        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(this);
//        config.threadPriority(Thread.NORM_PRIORITY - 2);
//        config.denyCacheImageMultipleSizesInMemory();
//        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
//        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
//        config.tasksProcessingOrder(QueueProcessingType.LIFO);
//        ImageLoader.getInstance().init(config.build());
//
        /***
         * 初始化定位sdk，建议在Application中创建
         */
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());

    }

//    private void initRxGallery() {
//        //打开日志
//        ModelUtils.setDebugModel(true);
//        Fresco.initialize(this);
//        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(this);
//        config.threadPriority(Thread.NORM_PRIORITY - 2);
//        config.denyCacheImageMultipleSizesInMemory();
//        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
//        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
//        config.tasksProcessingOrder(QueueProcessingType.LIFO);
//        ImageLoader.getInstance().init(config.build());
//
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);
//    }


    private void initACache() {
        //用户登录相关
        aCache = ACache.get(this);
        setUserLoginMainEntity((UserEntity) aCache.getAsObject(userinfo));

    }



    public static MyApplication getInstance(){
        return instance;
    }


    public UserEntity getUserLoginMainEntity() {
        return userLoginMainEntity;
    }

    public void setUserLoginMainEntity(UserEntity userLoginMainEntity) {

        this.userLoginMainEntity = userLoginMainEntity;
    }


    public String getUserid() {

        return String.valueOf(getUserLoginMainEntity().getId());
    }
//    public String getCangkuid() {
//
//        return String.valueOf(getUserLoginMainEntity().getCangKuId());
//    }
    public String getInNumber() {

        return String.valueOf(getUserLoginMainEntity().getTelephone());
    }
//    public String getUserName() {
//        //真实姓名
//        return String.valueOf(getUserLoginMainEntity().getUserLogin().getUserBaseInfo().getTrueName());
//    }

    //Activity相关
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }
    public void removeActivity(Activity activity) {
        activityList.remove(activity);
    }
    /**
     *     遍历所有Activity并finish
     */
    public void exit() {
        try {
            for (Activity activity : activityList) {
                activity.finish();
            }
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *     杀进程
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    public void out(Context context) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
//        builder.setMessage("您确认退出应用？");
//        builder.setTitle("提示");
//        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
////                SharedPreferences.Editor editor = sharedPrefs.edit();
////                editor.putString("AUTH_TOKEN","error");
////                editor.commit();
//                System.exit(0);
//
//            }
//        });
//
//        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        builder.create().show();
        aCache.remove(userinfo);
//        application.exit();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
