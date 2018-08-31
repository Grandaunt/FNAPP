package com.bcm.havoc.fnapp.Base.utils;//package com.bcm.havoc.warehousemanagement.Base;//package com.example.win.newintern3.Utils;
//
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.TextView;
//
//import com.bcm.havoc.warehousemanagement.R;
//
//
///**
// * Created by win on 2017/8/24.
// */
//
//public class ToolBarUtil {
//    public Toolbar toolbar;
//    /**
//     * 通用ToolBar 当存在是调用 布局文件 必须包含 single_toolbar.xml
//     * @param title 标题内容
//     * @param isBack 是否存在反回功能
//     */
//    protected void setToolBar(String title,boolean isBack,String save) {
//        toolbar = $findViewById(R.layout.toolbar);
//        toolbar.setVisibility(View.VISIBLE);
//        TextView tv_title = $findViewById(R.id.text_title);
//        tv_title.setText(title);
//        TextView tv_save = $findViewById(R.id.text_save);
//        tv_title.setText(title);
//        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
//        if (isBack) {
//            toolbar.setNavigationIcon(R.mipmap.ic_back);
//            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    finish();
//                }
//            });
//        }
//    }
//
//    /**
//     * 通用ToolBar 当存在是调用 布局文件 必须包含 single_toolbar.xml
//     * @param title 标题内容
//     * @param isBack 是否存在反回功能
//     */
//    protected void setToolBarColl(String title,boolean isBack,boolean isColl) {
//        toolbar = $findViewById(R.id.toolBar);
//        toolbar.setVisibility(View.VISIBLE);
//        TextView tv_title = $findViewById(R.id.text_title);
//        tv_title.setText(title);
//        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
//        if (isBack) {
//            toolbar.setNavigationIcon(R.mipmap.ic_back_white);
//            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    finish();
//                }
//            });
//        }
//    }
//    /**
//     //     * findViewById
//     //     * @param resId
//     //     * @param <T>
//     //     * @return
//     //     */
//    public <T extends View> T $findViewById(int resId) {
//        return (T) toolbar.findViewById(resId);
//    }
//}
