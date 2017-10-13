package cn.examsys.customer.dao.impl;

import cn.examsys.common.model.base.Student;
import cn.examsys.customer.dao.StudentDao;
import cn.examsys.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StudentDaoImpl implements StudentDao {
    /**
     * 学生登录
     *
     * @param username 用户名
     * @param password 密码
     * @return Student
     */
    @Override
    public Student login(String username, String password) {
        Student resultStu = null;
        //获取Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from Student as s where s.id = :id and s.password = :password")
                    .setString("id", username)
                    .setString("password", password);
            resultStu = (Student) query.uniqueResult();
            //提交事务
            transaction.commit();
        } catch (Exception e) {
            //发生异常则回滚事务
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return resultStu;
    }

    /**
     * 通过studentId获取Student
     *
     * @param studentId studentId
     * @return Student
     * @throws Exception
     */
    @Override
    public Student getStudentById(String studentId) throws Exception {
        Student student = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            student = (Student) session.get(Student.class, studentId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return student;
    }

    /**
     * 保存Student
     *
     * @param student 待保存的student
     * @throws Exception
     */
    @Override
    public void saveStudent(Student student) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
