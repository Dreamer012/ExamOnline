package cn.examsys.manager.dao;

import cn.examsys.common.model.base.Manager;


public interface ManagerDao {

    /**
     * 管理员登录
     *
     * @param username 用户名
     * @param password 密码
     * @return Manager
     * @throws Exception
     */
    Manager login(String username, String password) throws Exception;
}
