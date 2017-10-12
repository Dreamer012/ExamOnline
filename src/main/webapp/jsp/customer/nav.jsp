<%--
 *
 *  Created by IntelliJ IDEA.
 *  User: Bestick
 *  Date: 2016/4/7
 *  Time: 21:55
 *  Url: http://www.bestick.cn
 *  Copyright © 2015-2016 All rights reserved
 *  -----------------------------------------------------------
 *  会当凌绝顶，一览众山小。
 *
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nav navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">ExamSystem</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/resources/image/icon256x.png" class="navbar-logo-img">
            </a>
        </div>
        <div id="navbar-collapse" class="navbar-collapse collapse" role="navigation">
            <ul class="nav navbar-nav">
                <li>
                    <a href="${pageContext.request.contextPath}/paper!list" class="navbar-button">在线考试</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/exam!list?studentId=${currentUser.id}"
                       class="navbar-button">成绩查询</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/student!preUpdatePassword"
                       class="navbar-button">修改密码</a>
                </li>
                <li>
                    <a href="javascript:logout();" class="navbar-button">安全退出</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<script>
    function logout() {
        if (confirm("确定要安全退出考试系统吗？")) {
            location.assign("/student!logout");
            return true;
        } else {
            return false;
        }
    }
</script>