package cn.bestick.examsys.manager.dao;

import cn.bestick.examsys.common.model.base.Manager;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/22
 * Time: 22:58
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
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
