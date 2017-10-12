package cn.bestick.examsys.common.action;

import cn.bestick.examsys.customer.dao.StudentDao;
import cn.bestick.examsys.customer.dao.impl.StudentDaoImpl;
import cn.bestick.examsys.manager.dao.ManagerDao;
import cn.bestick.examsys.manager.dao.impl.ManagerDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/22
 * Time: 22:52
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class LoginAction extends ActionSupport implements ServletRequestAware {

    /**
     * request
     */
    private HttpServletRequest request;

    /**
     * StudentDao
     */
    private StudentDao studentDao = new StudentDaoImpl();

    /**
     * ManagerDao
     */
    private ManagerDao managerDao = new ManagerDaoImpl();

    /**
     * errorInfo
     */
    private String errorInfo;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * student(1),manager(2)
     */
    private int flag;

    /**
     * 登录Action
     *
     * @return String
     * @throws Exception
     */
    public String login() throws Exception {
        HttpSession session = request.getSession();
        Object currentUser = null;
        if (flag == 1) {
            currentUser = studentDao.login(username, password);
        }
        if (flag == 2) {
            currentUser = managerDao.login(username, password);
        }
        if (currentUser == null) {
            errorInfo = "准考证号或密码错误";
            return ERROR;
        }
        session.setAttribute("currentUser", currentUser);

        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
