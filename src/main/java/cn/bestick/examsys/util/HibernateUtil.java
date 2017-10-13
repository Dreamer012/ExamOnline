package cn.bestick.examsys.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/2
 * Time: 11:04
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class HibernateUtil {

    /**
     * SessionFactory
     */
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * 建议SessionFactory
     *
     * @return SessionFactory
     */
    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * 获取SessionFactory
     *
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void main(String[] args) {
        getSessionFactory();
        System.out.println(111);
    }

}
