package com.bcm.havoc.fnapp.Base.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.bcm.havoc.fnapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by TAO_SX on 2016/4/10/010.
 */
public class DateDialog {
    private Context context;
    private LayoutInflater inflater;
    private View v;
    private DatePicker datePicker;
    private AlertDialog.Builder dialog;
    private  int  post;
    public DateDialog(Context context) {
        this.context = context;

    }


    /**
     * yyyy/MM/dd
     *
     * @param editText
     * @param StartTime
     * @param EndTime
     */
    public void setting(final TextView editText, String StartTime, String EndTime) {

        inflater = LayoutInflater.from(context);
        v = inflater.inflate(R.layout.view_datepickerdialog, null);
        datePicker = (DatePicker) v.findViewById(R.id.datepicker);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (StartTime != null) {
            try {
                datePicker.setMinDate(sdf.parse(StartTime).getTime()+86400000);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(EndTime != null){
            try {
                datePicker.setMaxDate(sdf.parse(EndTime).getTime()+86400000);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

//        datePicker.init(date.getYear(),date.getMonth(),date.getDay(), null);
        dialog = new AlertDialog.Builder(context,R.style.MyAlertDialogLightStyle);

        try {
            /* 处理android5.0以上的特殊情况 */
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
                v.setBackgroundColor(0xFF000000);
                dialog = new AlertDialog.Builder(context,R.style.MyAlertDialogDrakStyle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        if (datePicker != null) {
//            datePicker.init(nyear, nmonth, nday, new DatePicker.OnDateChangedListener() {
//                @Override
//                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                    KLog.e("onDateChanged");
//                    if (isDateAfter(view)) {
//
//                        view.init(eyear, emonth, eday, this);
//                    }
//                    if (isDateBefore(view)) {
//                        view.init(syear, smonth, sday, this);
//                    }
//                }
//
//                private boolean isDateAfter(DatePicker tempView) {
//                    if (tempView.getYear() >= eyear){
//                        KLog.e("isDateAfter--->true");
//                        return true;
//
//
//                    }else{
//                        KLog.e("isDateAfter--->false");
//                        return false;
//                    }
//
//                }
//
//                private boolean isDateBefore(DatePicker tempView) {
//                    if (tempView.getYear() <= eyear) {
//                        KLog.e("isDateBefore--->true");
//                        return true;
//                    } else{
//                        KLog.e("isDateBefore--->false");
//                        return false;
//                    }
//
//                }
//            });
//        }

        dialog.setTitle(
                datePicker.getYear() + "年"
                        + (datePicker.getMonth() + 1) + "月"
                        + datePicker.getDayOfMonth() + "日")
                .setView(v)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String date = "";
                        date = datePicker.getYear() + "-";
                        //数据不足两位补0操作
                        if (String.valueOf(datePicker.getMonth() + 1).length() < 2) {
                            date += "0" + String.valueOf(datePicker.getMonth()+ 1)  + "-";
                        } else {
                            date += String.valueOf(datePicker.getMonth() + 1) + "-";
                        }

                        if (String.valueOf(datePicker.getDayOfMonth()).length() < 2) {
                            date += "0" + datePicker.getDayOfMonth() ;
                        } else {
                            date += String.valueOf(datePicker.getDayOfMonth()) ;
                        }
                        editText.setText(date);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                })
                .create().show();
    }

    public void setting(final EditText editText) {
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(context, 0, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear,
                                  int startDayOfMonth) {
                String textString = String.format("%d-%d", startYear,
                        startMonthOfYear + 1);
                editText.setText(textString);
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE)).show();
    }


    public int setList(final String title, final TextView resultText, final String[] datas) {
        post = 0;
        dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title);
//        dialog.setBa(title);
        dialog .setItems(datas, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                post = which;


                resultText.setText(datas[which]);

            }
        });
        dialog.show();

        return post;
    }

}
