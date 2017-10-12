<%--
 *
 *  Created by IntelliJ IDEA.
 *  User: Bestick
 *  Date: 2016/4/9
 *  Time: 15:27
 *  Url: http://www.bestick.cn
 *  Copyright © 2015-2016 All rights reserved
 *  -----------------------------------------------------------
 *  会当凌绝顶，一览众山小。
 *
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="selectPaper">
    <form action="paper!getDetailPaper" method="post" onsubmit="return checkForm();">
        <span>请选择考试试卷：</span>
        <select title="选项..." id="paperId" name="paperId">
            <option value="">请选择...</option>
            <c:forEach var="paper" items="${papers}">
                <option value="${paper.id}">${paper.paperName}</option>
            </c:forEach>
        </select>
        <div class="selectPaper-ctrl">
            <input type="submit" class="btn btn-info" value="确定"/>
            <input type="button" class="btn btn-info" value="返回" onclick="history.go(-1);">
        </div>
    </form>
</div>
<script>
    function checkForm() {
        var selectedPaperId = $('#paperId').val();
        if (selectedPaperId == "" || selectedPaperId == null) {
            alert("请选择试卷！");
            return false;
        }
        return true;
    }
</script>
