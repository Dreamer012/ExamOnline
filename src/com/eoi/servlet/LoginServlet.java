package com.eoi.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eoi.biz.LoginBiz;
import com.eoi.util.ResponseUtil;

/**
 * 管理员登录
 * @author xjf
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int status;
        Map<String, String[]> map = request.getParameterMap();

        HashMap<String, String> result = new LoginBiz().checklogin(map);

        if(result != null){
            HttpSession session = request.getSession();
            session.setAttribute("login_info", result);
            try {
                ResponseUtil.write("{'status':1,'msg':'登陆成功'}",response);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            try {
                ResponseUtil.write("{'status':0,'msg':'用户名或密码错误'}",response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
