package com.bcm.havoc.fnapp.Base.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bcm.havoc.fnapp.Base.utils.logger.Logger;

import java.util.List;


/**
 * Created by TAO_SX on 2016/4/19/019.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "wm.db";
    private static final int VERSION = 1;
    public static SQLiteHelper ourInstance;

    private SQLiteHelper(Context context) {
        this(context, DB_NAME, null, VERSION);
    }

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static SQLiteHelper getInstance(Context context) {
        if (ourInstance == null) ourInstance = new SQLiteHelper(context);
        return ourInstance;
    }

    public static final String TB_Stock_In = "Stock_In";
    public static final String ID = "Id";
    public static final String InNumber = "InNumber";
    public static final String SupplierNumber = "SupplierNumber";
    public static final String CangKuId = "CangKuId";
    public static final String InTime = "InTime";
    public static final String State = "State";
    public static final String Task = "Task";
    public static final String Operator = "Operator";

    public static final String TB_Stock_Out = "Stock_Out";
    public static final String OutNumber = "OutNumber";
    public static final String TakeCompany = "TakeCompany";
    public static final String OutTime = "OutTime";
    public static final String MetaialNumber = "MetaialNumber";

    public static final String TB_Stock_Check = "Stock_Check";
    public static final String CheckNumber = "CheckNumber";
    public static final String CheckName = "CheckName";
    public static final String CreateTime = "CreateTime";

    public static final String TB_Stock_In_Detail = "Stock_In_Detail";
    public static final String KuWerNumber = "KuWerNumber";
    public static final String ItemNumber = "ItemNumber";
    public static final String ItemSku = "ItemSku";
    public static final String Unit = "Unit";
    public static final String Amount = "Amount";
    public static final String UnitPrice = "UnitPrice";
    public static final String TotalPrice = "TotalPrice";

    public static final String TB_Stock_Out_Detail = "Stock_Out_Detail";
    public static final String TB_Stock_Check_Detail = "Stock_Check_Detail";
    public static final String Stock = "Stock";
    public static final String CheckNum = "CheckNum";
    public static final String ReplayNum = "ReplayNum";
    public static final String ItemName  = "ItemName";
    public static final String SupplierName  = "SupplierName";

//入库表
    public static final String TB_STOCK_IN_SQL = "CREATE TABLE IF NOT EXISTS " + TB_Stock_In + "(" +
        ID + " INTEGER NOT NULL," +
        InNumber + " INTEGER NOT NULL," +
        SupplierNumber + " INTEGER NOT NULL," +
        CangKuId + " INTEGER NOT NULL," +
        InTime + " INTEGER NOT NULL," +
        State + " INTEGER NOT NULL," +
        Task + " INTEGER NOT NULL," +
        SupplierName + " INTEGER NOT NULL," +
        Operator + " Text NOT NULL)";


    //出库表
    public static final String TB_STOCK_OUT_SQL = "CREATE TABLE IF NOT EXISTS " + TB_Stock_Out + "(" +
            ID + " INTEGER NOT NULL," +
            OutNumber + " INTEGER NOT NULL," +
            TakeCompany + " INTEGER NOT NULL," +
            CangKuId + " INTEGER NOT NULL," +
            OutTime + " INTEGER NOT NULL," +
            MetaialNumber + " INTEGER NOT NULL," +
            State + " INTEGER NOT NULL," +
            Task + " INTEGER NOT NULL," +
            Operator + " Text NOT NULL)";

    //盘点表
    public static final String TB_STOCK_CHECK_SQL = "CREATE TABLE IF NOT EXISTS " + TB_Stock_Check + "(" +
            ID + " INTEGER NOT NULL," +
            CheckNumber + " INTEGER NOT NULL," +
            CheckName + " INTEGER NOT NULL," +
            CangKuId + " INTEGER NOT NULL," +
            CreateTime + " INTEGER NOT NULL," +
            State + " INTEGER NOT NULL," +
            Task + " INTEGER NOT NULL," +
            Operator + " Text NOT NULL)";

    //入库明细表
    public static final String TB_STOCK_IN_DETAIL_SQL = "CREATE TABLE IF NOT EXISTS " + TB_Stock_In_Detail + "(" +
            ID + " INTEGER NOT NULL," +
            InNumber + " INTEGER NOT NULL," +
            KuWerNumber + " INTEGER NOT NULL," +
            ItemNumber + " INTEGER NOT NULL," +
            ItemSku + " INTEGER NOT NULL," +
            Unit + " INTEGER NOT NULL," +
            Amount + " INTEGER NOT NULL," +
            UnitPrice + " INTEGER NOT NULL," +
            TotalPrice + " INTEGER NOT NULL," +
            ItemName  + " INTEGER NOT NULL," +
            State + " Text NOT NULL)";
    //出库明细表
    public static final String TB_STOCK_OUT_DETAIL_SQL = "CREATE TABLE IF NOT EXISTS " + TB_Stock_Out_Detail + "(" +
            ID + " INTEGER NOT NULL," +
            OutNumber + " INTEGER NOT NULL," +
            KuWerNumber + " INTEGER NOT NULL," +
            ItemNumber + " INTEGER NOT NULL," +
            ItemSku + " INTEGER NOT NULL," +
            Unit + " INTEGER NOT NULL," +
            Amount + " INTEGER NOT NULL," +
            UnitPrice + " INTEGER NOT NULL," +
            TotalPrice + " INTEGER NOT NULL," +
            State + " Text NOT NULL)";

    //盘点明细表
    public static final String TB_STOCK_CHECK_DETAIL_SQL = "CREATE TABLE IF NOT EXISTS " + TB_Stock_Check_Detail + "(" +
            ID + " INTEGER NOT NULL," +
            CheckNumber + " INTEGER NOT NULL," +
            KuWerNumber + " INTEGER NOT NULL," +
            ItemNumber + " INTEGER NOT NULL," +
            Stock + " INTEGER NOT NULL," +
            CheckNum + " INTEGER NOT NULL," +
            ReplayNum + " INTEGER NOT NULL," +
            State + " Text NOT NULL)";

//            public static final String INIT_CITY_SQL = "INSERT  TB_City IF NOT EXISTS " + TB_City + "("+
//            TB_FirstChar + " INTEGER NOT NULL," +
//            TB_CityName + " INTEGER NOT NULL," +
//            TB_ParentCode + " INTEGER NOT NULL," +
//            TB_CityCode + " INTEGER NOT NULL," +
//            TB_CityLevel + " Text NOT NULL)";

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     * 首次创建数据库时调用。这就是创建表和表的初始种群。
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_Stock_In);
        db.execSQL(TB_STOCK_IN_SQL);
        db.execSQL("DROP TABLE IF EXISTS " + TB_Stock_Out);
        db.execSQL(TB_STOCK_OUT_SQL);
        db.execSQL("DROP TABLE IF EXISTS " + TB_Stock_Check);
        db.execSQL(TB_STOCK_CHECK_SQL);
        db.execSQL("DROP TABLE IF EXISTS " + TB_Stock_In_Detail);
        db.execSQL(TB_STOCK_IN_DETAIL_SQL);
        db.execSQL("DROP TABLE IF EXISTS " + TB_Stock_Out_Detail);
        db.execSQL(TB_STOCK_OUT_DETAIL_SQL);
        db.execSQL("DROP TABLE IF EXISTS " + TB_Stock_Check_Detail);
        db.execSQL(TB_STOCK_CHECK_DETAIL_SQL);
//        db.execSQL(INIT_CITY_SQL);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * 数据库需要更新时调用，实现类应该使用这个方法删除表，添加表，或者做其他事情需要更新表到新模式版本
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * 如果你添加新的列你可以使用ALTER TABLE插入到现存的表里。如果你想重命名或移除列你可以使用ALTER TABLE重命名
     * 旧表，然后创建新表，接着填充新表与旧表的内容
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * 这个方法执行了一个事务。如果抛出一个异常，所有更改将自动回滚。
     * </p>
     *
     * @param db         The database. 数据库
     * @param oldVersion The old database version. 旧数据库版本
     * @param newVersion The new database version. 新数据库版本
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            Logger.d("更新数据库");
        }
    }


    /**
     * 删除城市表
     */
    public void deleteTable(String table) {
        SQLiteDatabase delete = this.getWritableDatabase();
        delete.execSQL("DROP TABLE " + table);
        delete.close();
    }

    /**
     * 清空城市表
     */
    public void deleteAll(String table) {
        SQLiteDatabase deleteAll = this.getWritableDatabase();
        deleteAll.delete(table, null, null);
        deleteAll.close();
    }

    /**
     * 添加城市
     *
     * @param table             表名
     * @param contentValuesList 值
     */
    public void insert(String table, List<ContentValues> contentValuesList) {
        if (contentValuesList != null && contentValuesList.size() > 0) {
            SQLiteDatabase db = this.getWritableDatabase();
            //使用事务提交
            db.beginTransaction();
            try {
                for (ContentValues contentValues : contentValuesList) {
                    db.replace(table, null, contentValues);
                }
                db.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                db.endTransaction();
            }

            db.close();//关闭DB
        }
    }

    /**
     * 查询数据
     *
     * @param table         表名
     * @param columns       要查询出来的列名，为 null 查询所有
     * @param selection     查询条件，允许使用占位符"?"
     * @param selectionArgs 对应于selection语句中占位符的值
     * @param groupBy       分组
     * @param having        过滤器
     * @param orderBy       排序
     * @param limit         限制查询返回的行数，
     * @return Cursor 注意使用完要关闭
     */
    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy, String limit) {
        Cursor c = this.getWritableDatabase().query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
//        DBManager.getInstance().closeDatabase();//关闭DB
        //游标必须要在关闭数据库之前关闭，不能放在后面
        return c;
    }

}
