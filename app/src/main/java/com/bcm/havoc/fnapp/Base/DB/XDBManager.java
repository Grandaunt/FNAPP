package com.bcm.havoc.fnapp.Base.DB;

import android.util.Log;

import org.xutils.DbManager;
import org.xutils.db.table.TableEntity;
import org.xutils.x;

import java.io.File;

/**
 * Created by win on 2017/6/10.
 */

public class XDBManager {
    public static DbManager.DaoConfig daoConfig;
    public static DbManager db;
    public static DbManager.DaoConfig getDaoConfig() {
        daoConfig = new DbManager.DaoConfig()
//设置数据库名，默认xutils.db
                .setDbName("DB_SJS_WM.db")
                //设置数据库路径，默认存储在app的私有目录/mnt/sdcard/
                .setDbDir(new File("/mnt/sdcard/wm"))
                //设置数据库的版本号
                .setDbVersion(3);
        return daoConfig;
    }
    /**
     * 初始化DaoConfig配置
     */
    public static void initDb() {
        daoConfig = new DbManager.DaoConfig()
//设置数据库名，默认xutils.db
                .setDbName("DB_SJS_WM.db")
                //设置数据库路径，默认存储在app的私有目录/mnt/sdcard/
                .setDbDir(new File("/mnt/sdcard/wm"))
                //设置数据库的版本号
                .setDbVersion(3)
                //设置数据库打开的监听
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        //开启数据库支持多线程操作，提升性能，对写入加速提升巨大
                        db.getDatabase().enableWriteAheadLogging();
                    }
                })
                //设置数据库更新的监听
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
//                        //不需要之前的数据
//                        try {
//                            db.delete(KuQu.class);
//                            db.delete(KuWei.class);
//                        } catch (DbException e) {
//                            e.printStackTrace();
//                        }
//需要之前的数据
//                        db.addColumn(x.class,"test");//新增的字段
//                        db.saveOrUpdate(db.findall（）);//当前表中有这条isId则更新数据，没有则添加
                    }
                })
                //设置表创建的监听
                .setTableCreateListener(new DbManager.TableCreateListener() {
                    @Override
                    public void onTableCreated(DbManager db, TableEntity<?> table) {
                        Log.i("JAVA", "onTableCreated：" + table.getName());

                    }
                });
        //设置是否允许事务，默认true
//    .setAllowTransaction(true)
        db = x.getDb(daoConfig);
    }

}
