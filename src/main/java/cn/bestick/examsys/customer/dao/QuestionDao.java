package cn.bestick.examsys.customer.dao;

import cn.bestick.examsys.common.model.base.Question;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/15
 * Time: 16:40
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
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
