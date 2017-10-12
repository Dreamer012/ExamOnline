<%--
 *
 *  Created by IntelliJ IDEA.
 *  User: Bestick
 *  Date: 2016/4/20
 *  Time: 13:29
 *  Url: http://www.bestick.cn
 *  Copyright © 2015-2016 All rights reserved
 *  -----------------------------------------------------------
 *  会当凌绝顶，一览众山小。
 *
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="update-password">
    <p class="title">修改密码</p>
    <form id="update-pwd" action="student!updatePassword" method="post" onsubmit="return checkForm();">
        <p>
            <label for="username">准考证：</label>
            <input type="text" name="student.id" id="username" value="${currentUser.id}" readonly="readonly">
        </p>
        <p>
            <label for="pwd">原密码：</label>
            <input type="password" id="pwd">
        </p>
        <p>
            <label for="new-pwd">新密码：</label>
            <input type="password" id="new-pwd" name="student.password">
        </p>
        <p style="position: relative;left: -15px;">
            <label for="renew-pwd">确认新密码：</label>
            <input type="password" id="renew-pwd">
        </p>
        <input type="submit" class="btn btn-info" value="提交">
    </form>
</div>
<script>
    function checkForm() {
        var pwd = $('#pwd').val();
        var newPwd = $('#new-pwd').val();
        var reNewPwd = $('#renew-pwd').val();
        if (pwd === null || pwd === "") {
            alert("原密码不能为空！");
            return false;
        }
        if (pwd !== '${currentUser.password}') {
            alert("原密码输入错误，请重试！");
            return false;
        }
        if (newPwd === null || newPwd === "") {
            alert("新密码不能为空！");
            return false;
        }
        if (reNewPwd === null || reNewPwd === "") {
            alert("确认密码不能为空！");
            return false;
        }
        if (newPwd !== reNewPwd) {
            alert("两次输入密码不一致，请重试！");
            return false;
        }
        return true;
    }
</script>