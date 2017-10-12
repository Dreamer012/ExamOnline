package cn.bestick.examsys.customer.dao.impl;

import cn.bestick.examsys.common.model.base.Question;
import cn.bestick.examsys.customer.dao.QuestionDao;
import cn.bestick.examsys.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/15
 * Time: 16:45
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
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
