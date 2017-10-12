package cn.bestick.examsys.customer.dao;

import cn.bestick.examsys.common.model.base.Student;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/5
 * Time: 18:00
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
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
