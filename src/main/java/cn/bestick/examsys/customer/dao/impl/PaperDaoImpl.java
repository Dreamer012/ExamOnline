package cn.bestick.examsys.customer.dao.impl;

import cn.bestick.examsys.common.model.base.Paper;
import cn.bestick.examsys.customer.dao.PaperDao;
import cn.bestick.examsys.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/9
 * Time: 14:47
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class PaperDaoImpl implements PaperDao {


    /**
     * 获取试卷列表
     *
     * @return List<Paper>
     */
    @Override
    public List<Paper> getPapers() {
        List<Paper> papers = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from Paper");
            papers = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return papers;
    }

    /**
     * 根据试卷id获取具体试卷
     *
     * @return Paper
     */
    @Override
    public Paper getPaper(Integer paperId) {
        Paper paper = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            paper = (Paper) session.get(Paper.class, paperId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return paper;
    }
}
