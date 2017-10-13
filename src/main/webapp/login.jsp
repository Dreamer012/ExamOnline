
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Title -->
    <title>登录</title>

    <jsp:include page="${initParam.pageHeaderLib}"/>
</head>
<body>

<div class="login-box">
    <form id="loginForm" action="api!login" onsubmit="return checkForm();" method="post">
        <div class="form-box">
            <p>
                <span>准考证号：</span>
                <input type="text" id="id" name="username" value="${username}"/>
            </p>
            <p>
                <span>登录密码：</span>
                <input type="password" id="password" name="password" value="${password}"/>
            </p>
            <p>
                <span>登录身份：</span>
                <select id="flag" name="flag">
                    <option value="1">考生</option>
                    <option value="2">管理员</option>
                </select>
            </p>
            <p>
                <input type="submit" class="btn btn-danger" value="登录"/>
                <input type="button" onclick="resetForm();" class="btn btn-danger" value="重置"/>
            </p>
        </div>
    </form>
</div>

<jsp:include page="${initParam.pageFooterLib}"/>

<script>
    function resetForm() {
        $('#id').val('');
        $('#password').val('');
    }
    function checkForm() {
        var id = $('#id').val();
        var pwd = $('#password').val();
        if (id == null || id == '') {
            alert("用户名不能为空！");
            return false;
        }
        if (pwd == null || pwd == '') {
            alert("密码不能为空！");
            return false;
        }
        return true;
    }
    if ('${errorInfo}' != '') {
        alert('${errorInfo}');
    }
</script>
</body>
</html>
