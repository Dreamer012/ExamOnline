package com.eoi.dao;

import java.util.HashMap;
import java.util.List;

public class LoginDAO extends BaseDAO{
    private String CHECK_LOGIN = "select * from user where uid=? and pwd=?";
    /**
     * 登录
     * @param uid 管理账号
     * @param pwd 管理员密码
     * @return 管理员信息
     */
    public List<HashMap<String,String>> checklogin(String uid,String pwd){
        return super.findBySql(CHECK_LOGIN ,uid,pwd);
    }
}
