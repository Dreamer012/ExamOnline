package cn.bestick.examsys.customer.dao.impl;

import cn.bestick.examsys.common.model.base.Exam;
import cn.bestick.examsys.customer.dao.ExamDao;
import cn.bestick.examsys.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/15
 * Time: 16:37
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class ExamDaoImpl implements ExamDao {

    /**
     * 保存考试信息
     *
     * @param exam Exam实体
     */
    @Override
    public void saveExam(Exam exam) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(exam);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * 查询考试信息
     *
     * @param studentId 学生id
     * @return Exam
     */
    @Override
    public List<Exam> getExamList(String studentId) throws Exception {
        List<Exam> examList = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            examList = session.createQuery("from Exam e where e.student.id = :studentId")
                    .setString("studentId", studentId)
                    .list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return examList;
    }
}
