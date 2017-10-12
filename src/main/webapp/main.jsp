<%--
 *
 *  Created by IntelliJ IDEA.
 *  User: Bestick
 *  Date: 2016/4/6
 *  Time: 22:55
 *  Url: http://www.bestick.cn
 *  Copyright © 2015-2016 All rights reserved
 *  -----------------------------------------------------------
 *  会当凌绝顶，一览众山小。
 *
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ExamSystem</title>

    <jsp:include page="${initParam.pageHeaderLib}"/>
</head>
<body id="body">

<!-- 引入头部 -->
<jsp:include page="${initParam.pageHeader}"/>

<!-- 引入导航 -->
<jsp:include page="${initParam.pageNav}"/>

<!-- 引入中部 -->
<jsp:include page="${(mainPage == null || mainPage == '') ? initParam.mainPage : mainPage}"/>
<%--<jsp:include page="${initParam.mainPage}"/>--%>
<!-- 引入尾部 -->
<jsp:include page="${initParam.pageFooter}"/>

<jsp:include page="${initParam.pageFooterLib}"/>
</body>
</html>
