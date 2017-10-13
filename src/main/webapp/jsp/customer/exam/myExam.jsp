
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="myExam">
    <p class="table-title">${currentUser.name } 成绩列表</p>
    <table class="table table-hover">
        <tr>
            <th>序号</th>
            <th>试卷名称</th>
            <th>考试时间</th>
            <th>单选题得分</th>
            <th>多选题得分</th>
            <th>总分</th>
        </tr>
        <c:forEach var="exam" items="${examList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${exam.paper.paperName}</td>
                <td><fmt:formatDate value="${exam.examDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${exam.singleScore}</td>
                <td>${exam.multipleScore}</td>
                <td>${exam.sumScore}</td>
            </tr>
        </c:forEach>
    </table>
</div>
