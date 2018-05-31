package com.dh.ddfx.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by duh on 2018/5/26 2:20.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
public class DbUtils {
    private String dbUrl ="jdbc:mysql://192.168.0.13:3306/db_shop";
    private String dbUserName ="root";
    private String dbPassword="elab@123";
    //	private String dbPassword="96zhuyongxin";
    private String jdbcName = "com.mysql.jdbc.Driver";

    public Connection getCon()throws Exception{
        Class.forName(jdbcName);
        Connection Con= DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return Con;

    }
    public void closeCon(Connection con)throws Exception{
        if(con!=null){
            con.close();
        }
    }
    public static void main(String[] args) {
        DbUtils dbUtil=new DbUtils();
        try {
            dbUtil.getCon();
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
