package cn.examsys.customer.dao.impl;

import cn.examsys.common.model.base.Paper;
import cn.examsys.customer.dao.PaperDao;
import cn.examsys.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


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
