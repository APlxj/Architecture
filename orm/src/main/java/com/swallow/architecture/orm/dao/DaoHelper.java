package com.swallow.architecture.orm.dao;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class DaoHelper {

    /*public final static String DATABASE_NAME = "shopping.db";
    private static DaoSession daoSession;

    *//**
     * 初始数据库
     *//*
    public static void init(@NonNull Context context) {
        //创建数据库shop.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DATABASE_NAME, null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取dao对象管理者
        daoSession = daoMaster.newSession();
        //用于打印错误日志
        if (BuildConfig.DEBUG) {
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
        }
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }*/
}
