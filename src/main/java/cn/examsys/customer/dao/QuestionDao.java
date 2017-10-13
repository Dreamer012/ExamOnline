package cn.examsys.customer.dao;

import cn.examsys.common.model.base.Question;


public interface QuestionDao {

    /**
     * 通过题目id获取题目
     *
     * @param questionId 题目id
     * @return Question
     * @throws Exception
     */
    Question getQuestion(Integer questionId) throws Exception;
}
