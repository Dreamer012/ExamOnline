package cn.examsys.customer.dao;

import cn.examsys.common.model.base.Student;


public interface StudentDao {

    /**
     * 学生登录
     *
     * @param username 用户名
     * @param password 密码
     * @return Student
     * @throws Exception
     */
    Student login(String username, String password) throws Exception;

    /**
     * 通过studentId获取Student
     *
     * @param studentId studentId
     * @return Student
     * @throws Exception
     */
    Student getStudentById(String studentId) throws Exception;

    /**
     * 保存Student
     *
     * @param student 待保存的student
     * @throws Exception
     */
    void saveStudent(Student student) throws Exception;
}
