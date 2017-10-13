package cn.examsys.customer.dao.impl;

import cn.examsys.common.model.base.Question;
import cn.examsys.customer.dao.QuestionDao;
import cn.examsys.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class QuestionDaoImpl implements QuestionDao {

    /**
     * 通过题目id获取题目
     *
     * @param questionId 题目id
     * @return Question
     */
    @Override
    public Question getQuestion(Integer questionId) {
        Question question = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            question = (Question) session.get(Question.class, questionId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return question;
    }
}
