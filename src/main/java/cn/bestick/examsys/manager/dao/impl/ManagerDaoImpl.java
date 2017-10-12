package cn.bestick.examsys.manager.dao.impl;

import cn.bestick.examsys.common.model.base.Manager;
import cn.bestick.examsys.manager.dao.ManagerDao;
import cn.bestick.examsys.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/22
 * Time: 23:03
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class ManagerDaoImpl implements ManagerDao {

    /**
     * 管理员登录
     *
     * @param username 用户名
     * @param password 密码
     * @return Manager
     */
    @Override
    public Manager login(String username, String password) {
        Manager result = null;
        //获取Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from Manager as m where m.userName = :userName and m.password = :password")
                    .setString("userName", username)
                    .setString("password", password);
            result = (Manager) query.uniqueResult();
            //提交事务
            transaction.commit();
        } catch (Exception e) {
            //发生异常则回滚事务
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
