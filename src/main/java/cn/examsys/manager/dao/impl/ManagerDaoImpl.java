package cn.examsys.manager.dao.impl;

import cn.examsys.common.model.base.Manager;
import cn.examsys.manager.dao.ManagerDao;
import cn.examsys.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


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
