package com.bcm.havoc.fnapp.Base.service;//package com.bcm.havoc.gnapp.service;
//
///**
// * @Author misolamiso.
// * @Date 2018/8/29-9:44
// */
//
//import android.content.SharedPreferences;
//import android.util.Log;
//
//import com.baidu.location.BDLocation;
//import com.baidu.location.BDLocationListener;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * 定位SDK监听函数
// */
//public class MyLocationListenner implements BDLocationListener {
//
//    @Override
//    public void onReceiveLocation(BDLocation location) {
//        // map view 销毁后不在处理新接收的位置
//        if (location == null || mMapView == null) {
//            return;
//        }
//        mCurrentLat = location.getLatitude();
//        mCurrentLon = location.getLongitude();
//        mCurrentAccracy = location.getRadius();
//        mAddr = location.getAddrStr();
//        //获取地理位置开始
//        formatter =  new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
//        curDate =  new Date(System.currentTimeMillis());
//        Log.i("MyLocationListenner","mCurrentLat"+mCurrentLat+"mCurrentLon"+mCurrentLon+"mCurrentAccracy"+mCurrentAccracy+"mAddr"+mAddr);
//        if (mAddr == null || mAddr.length() <= 0){
//        }
//        else {
//            SharedPreferences.Editor editor = sharedPrefs.edit();
//            editor.putString("GPSTIMEStr",mAddr+"\n"+formatter.format(curDate));
//            editor.commit();
//        }
////            locData = new MyLocationData.Builder()
////                    .accuracy(location.getRadius())
////                    // 此处设置开发者获取到的方向信息，顺时针0-360
////                    .direction(mCurrentDirection).latitude(location.getLatitude())
////                    .longitude(location.getLongitude()).build();
//
////            mBaiduMap.setMyLocationData(locData);
////            if (isFirstLoc) {
////                isFirstLoc = false;
////                LatLng ll = new LatLng(location.getLatitude(),
////                        location.getLongitude());
////                MapStatus.Builder builder = new MapStatus.Builder();
////                builder.target(ll).zoom(18.0f);
////                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
////            }
//    }
//
//    @Override
//    public void onConnectHotSpotMessage(String s, int i) {
//
//    }
//
//}