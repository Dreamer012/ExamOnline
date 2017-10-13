package cn.bestick.examsys.customer.action;

import cn.bestick.examsys.common.model.base.Student;
import cn.bestick.examsys.customer.dao.StudentDao;
import cn.bestick.examsys.customer.dao.impl.StudentDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/5
 * Time: 18:12
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class StudentAction extends ActionSupport implements ServletRequestAware {

    /**
     * HttpServletRequest
     */
    private HttpServletRequest request;

    /**
     * StudentDao
     */
    private StudentDao studentDao = new StudentDaoImpl();

    /**
     * 登录页传入的student
     */
    private Student student;

    /**
     * error
     */
    private String error;

    /**
     * mainPage
     */
    private String mainPage;

    /**
     * 修改密码前
     *
     * @return String
     * @throws Exception
     */
    public String preUpdatePassword() throws Exception {
        mainPage = "jsp/customer/student/updatePassword.jsp";
        return SUCCESS;
    }

    /**
     * 修改密码
     *
     * @return String
     * @throws Exception
     */
    public String updatePassword() throws Exception {
        Student s = studentDao.getStudentById(student.getId());
        s.setPassword(student.getPassword());
        studentDao.saveStudent(s);
        mainPage = "jsp/customer/student/updateSuccess.jsp";
        return SUCCESS;
    }

    /**
     * 退出登录
     *
     * @return String
     * @throws Exception
     */
    public String logout() throws Exception {
        request.getSession().invalidate();
        return "logout";
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMainPage() {
        return mainPage;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
}
