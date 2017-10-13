package cn.examsys.customer.dao;

import cn.examsys.common.model.base.Exam;

import java.util.List;


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
