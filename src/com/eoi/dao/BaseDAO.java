package com.eoi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.eoi.util.DBUtil;

public class BaseDAO {
    private Connection con=null;
    private PreparedStatement pStatement=null;
    private ResultSet rs=null;
    public int executeUpdate(String sql,Object...args){
        int count = 0;
        try {
            con= DBUtil.getConnection();
            pStatement=con.prepareStatement(sql);
            if(args!=null){
                for(int i=0;i<args.length;i++){
                    pStatement.setObject(i+1, args[i]);
                }
            }
            count=pStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            DBUtil.close(pStatement, rs, con);
        }

        return count;

    }
    //输入查询的sql语句和对象参数，返回对象
    public  List<HashMap<String,String>> findBySql(String sql,Object...params){
        //<>将查询的内容放到hashmap对象中，然后将查询对象放到list中
        List<HashMap<String, String>> items=new ArrayList<HashMap<String,String>>();
        HashMap<String, String> item=null;
        try{
            con=DBUtil.getConnection();
            pStatement=con.prepareStatement(sql);
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    pStatement.setObject(i+1, params[i]);
                }
            }
            rs=pStatement.executeQuery();
            //获取查询结果，并将每行都存储到ashmap中M，全部行放到list中
            ResultSetMetaData meta=rs.getMetaData();
            int count=meta.getColumnCount();
            String[] colNames=new String[count];
            for(int i=0;i<count;i++){
                colNames[i]=meta.getColumnName(i+1);
            }
            while(rs.next()){
                item=new HashMap<String,String>();
                for(int i=0;i<count;i++){
                    String value =rs.getString(colNames[i]);
                    item.put(colNames[i].toLowerCase(), value);
                }
                items.add(item);
            }
        }catch(Exception e){
            throw new RuntimeException("抛出异常", e);
        }
        finally{
            DBUtil.close(pStatement, rs, con);
        }
        return items;
    }

}
