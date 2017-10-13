package cn.examsys.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


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
