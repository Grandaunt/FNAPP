package com.bcm.havoc.fnapp.Base.DB;

/**
 * Created by win on 2017/5/23.
 */
public class dbFaction {

    /***
     * 2）创建数据库
     * 用集合向child_info表中插入多条数据
     ArrayList<ChildInfo> childInfos = new ArrayList<>();
     childInfos.add(new ChildInfo("zhangsan"));
     childInfos.add(new ChildInfo("lisi"));
     childInfos.add(new ChildInfo("wangwu"));
     childInfos.add(new ChildInfo("zhaoliu"));
     childInfos.add(new ChildInfo("qianqi"));
     childInfos.add(new ChildInfo("sunba"));
     //db.save()方法不仅可以插入单个对象，还能插入集合
     db.save(childInfos);
     */

    /***
     * 3）删除数据库
     * db.dropDb();
     */

    /***
     *4）删除表
     * db.dropTable(ChildInfo.class);
     */

    /***
     * 5）新增表中的数据
     * ChildInfo childInfo = new ChildInfo("zhangsan123");
     db.save(childInfo);
     */

    /***
     * 6）删除表中的数据
     * //第一种写法：
     db.delete(ChildInfo.class); //child_info表中数据将被全部删除
     //第二种写法，添加删除条件：
     WhereBuilder b = WhereBuilder.b();
     b.and("id",">",2); //构造修改的条件
     b.and("id","<",4);
     db.delete(ChildInfo.class, b);
     */


    /***
     * 7）修改表中的数据
     * //第一种写法：
     ChildInfo first = db.findFirst(ChildInfo.class);
     first.setcName("zhansan2");
     db.update(first,"c_name"); //c_name：表中的字段名
     //第二种写法：
     WhereBuilder b = WhereBuilder.b();
     b.and("id","=",first.getId()); //构造修改的条件
     KeyValue name = new KeyValue("c_name","zhansan3");
     db.update(ChildInfo.class,b,name);
     //第三种写法：
     first.setcName("zhansan4");
     db.saveOrUpdate(first);
     */

    /***
     * 8）查询表中的数据//
     * 查询数据库表中第一条数据
     ChildInfo first = db.findFirst(ChildInfo.class);
     Log.i("JAVA",first.toString());
     //添加查询条件进行查询
     List<ChildInfo> all = db.selector(ChildInfo.class).where("id",">",2).and("id","<",4).findAll();
     for(ChildInfo childInfo :all){
     Log.i("JAVA",childInfo.toString());
     }
     */
}
