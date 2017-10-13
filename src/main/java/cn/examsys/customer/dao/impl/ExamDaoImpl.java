package cn.examsys.customer.dao.impl;

import cn.examsys.common.model.base.Exam;
import cn.examsys.customer.dao.ExamDao;
import cn.examsys.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


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
