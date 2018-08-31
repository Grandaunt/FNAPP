package com.bcm.havoc.fnapp.Base.application;

/**
 * Created by TAO_SX on 2016/6/28/028.
 */
public class URLConfig {
    public static final String weatherAPI = "http://api.map.baidu.com/telematics/v3/weather?location=%1$s&output=json&ak=7Ff4GL9wdGDOFkILauVBFgGRsNS5VrS4";
    public static final String SecretKey = "202CA26E33226DC";

    //-----------------------------------------API--------------------------------------------------
    //  http://yefeng411114.6655.la/api/receive/";
//    http://wms.bjszhgx.com/api/receive/userlogin
    public static final String URL = "http://wms.bjszhgx.com/api/";
//    public static final String URL2 = "http://182.92.173.223:8080/mainStudentWeb/";
//    public static final String URL = "http://172.16.10.204:8080/";

//    public static final String URL2 = "http://123.57.29.113:8080/mainStudentWeb/";
//    public static final String URL2 = "http://172.16.10.242:8080/mainStudentWeb/";
    //通知-通知列表
//    public static final String NoticePracticeAPI = URL + "trial/noticeinfo.do";
    //通知-通知列表
    public static final String LoginIn = URL + "receive/userlogin";
//    public static final String LoginIn = URL + "userlogin";
    //所有数据
    public static final String GetAllList = URL+ "send/GetAllList";
    //    http://182.92.173.223:8080/mainStudentWeb/androidversion/getLatestVersion
    public static final String CheckVersion = URL + "androidversion/getLatestVersion";
    //      http://yefeng411114.6655.la/api/send/getstockinlist?userid=1&cangkuid=10&md5=573ab1b5a353b3a69197c1ef4ff07c9e
//    public static final String URL_Stock_In =  "http://yefeng411114.6655.la/api/send/getstockinlist";
    public static final String URL_Stock_In = URL+ "send/GetStockInlist";
    //    http://182.92.173.223:8080/mainStudentWeb/androidversion/getLatestVersion
//    public static final String URL_Stock_In_Detail = "http://yefeng411114.6655.la/api/send/GetStockInDetailList";
    public static final String URL_Stock_In_Detail = URL+"send/GetStockInDetailList";

    public static final String URL_Stock_Check = URL+ "send/GetStockCheckList";
    public static final String URL_Stock_Check_Detail = URL+"send/GetStockCheckDetailList";
    public static final String URL_Stock_Out = URL+ "send/GetStockOutList";
    public static final String URL_Stock_Out_Detail = URL+"send/GetStockOutDetailList";
    public static final String URL_KUWEI = URL+"send/GetWmsKuWeiList";
    public static final String URL_KUQU = URL+"send/GetWmsKuQuList";
    public static final String URL_SUPPlIER = URL+"send/GetSupplierList";
    public static final String URL_Item_Info = URL+"send/GetItemList";
    public static final String URL_Stock_In_Ok = URL+"receive/SetStockInStatus";

    public static final String URL_RECV_Stock_In = URL + "receive/Recv_StockIn";
    public static final String URL_RECV_Stock_Check = URL + "receive/Recv_StockCheck";
    public static final String URL_RECV_Stock_Out = URL + "receive/Recv_StockOut";


}