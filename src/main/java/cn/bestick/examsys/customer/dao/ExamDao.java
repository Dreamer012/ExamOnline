package cn.bestick.examsys.customer.dao;

import cn.bestick.examsys.common.model.base.Exam;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/15
 * Time: 16:29
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public interface ExamDao {

    /**
     * 保存考试信息
     *
     * @param exam Exam实体
     * @throws Exception
     */
    void saveExam(Exam exam) throws Exception;

    /**
     * 查询考试信息
     *
     * @param studentId 学生id
     * @return List<Exam>
     * @throws Exception
     */
    List<Exam> getExamList(String studentId) throws Exception;
}
