package com.eoi.biz;

import com.eoi.dao.LoginDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginBiz {
    /**
     * 用于管理登录
     * @param map 管理员提交的账号和密码
     * @return true 表示登录成功，false 表示登录失败
     */
    public HashMap<String,String> checklogin(Map<String,String[]> map){
        String strUid = map.get("login_id")[0];
        String strPwd = map.get("login_pwd")[0];

        List<HashMap<String,String>> list = logindao.checklogin(strUid,strPwd);
        if(list != null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    /**
     * 构造方法
     */
    public LoginBiz(){
        logindao = new LoginDAO();
    }

    private LoginDAO logindao;
}
