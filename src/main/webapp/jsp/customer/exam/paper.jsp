<%--
 *
 *  Created by IntelliJ IDEA.
 *  User: Bestick
 *  Date: 2016/4/11
 *  Time: 10:50
 *  Url: http://www.bestick.cn
 *  Copyright © 2015-2016 All rights reserved
 *  -----------------------------------------------------------
 *  会当凌绝顶，一览众山小。
 *
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="detail-paper">
    <div class="time-info">
        <span>考试时间<strong>20:00</strong>分钟</span>
        <span>已用时间：<strong class="time-pass"></strong></span>
        <span>剩余时间：<strong class="time-remain"></strong></span>
    </div>
    <hr/>
    <div class="exam-info">
        <p class="title">${paper.paperName}&nbsp;&nbsp;考试卷</p>
        <p class="desc">（满分120，单选题60，多选题60）</p>
    </div>
    <form id="answer-form" action="exam!add" method="post">
        <input type="hidden" name="exam.student.id" value="${currentUser.id}">
        <input type="hidden" name="exam.paper.id" value="${paper.id}">
        <div class="single-question">
            <p class="question-title">
                <span>一、单选题</span>(每题20分，答错不得分)
            </p>
            <div class="question-box">
                <c:forEach var="s" items="${singleList}" varStatus="status">
                    <p class="subQuestion-title">(${status.index + 1}) ${s.subject}</p>
                    <label class="radio">
                        <input type="radio" name="id-r-${s.id}" value="A">
                            ${s.optionA}
                    </label>
                    <label class="radio">
                        <input type="radio" name="id-r-${s.id}" value="B">
                            ${s.optionB}
                    </label>
                    <label class="radio">
                        <input type="radio" name="id-r-${s.id}" value="C">
                            ${s.optionC}
                    </label>
                    <label class="radio">
                        <input type="radio" name="id-r-${s.id}" value="D">
                            ${s.optionD}
                    </label>
                </c:forEach>
            </div>
        </div>
        <hr/>
        <div class="multiple-question">
            <p class="question-title">
                <span>二、多选题</span>(每题30分，答错不得分)
            </p>
            <div class="question-box">
                <c:forEach var="m" items="${multipleList}" varStatus="status">
                    <p class="subQuestion-title">(${status.index + 1}) ${m.subject}</p>
                    <label class="checkbox">
                        <input type="checkbox" name="id-m-${m.id}" value="A">
                            ${m.optionA}
                    </label>
                    <label class="checkbox">
                        <input type="checkbox" name="id-m-${m.id}" value="B">
                            ${m.optionB}
                    </label>
                    <label class="checkbox">
                        <input type="checkbox" name="id-m-${m.id}" value="C">
                            ${m.optionC}
                    </label>
                    <label class="checkbox">
                        <input type="checkbox" name="id-m-${m.id}" value="D">
                            ${m.optionD}
                    </label>
                </c:forEach>
            </div>
        </div>
        <input type="submit" class="btn btn-info" value="交卷">
    </form>
</div>
<script>
    //考试总时间
    var totalTime = 20 * 60;
    //已用时间
    var passTime = 0;
    //剩余时间
    var remainTime = totalTime;

    /**
     * 计时器
     */
    function timeCounter() {
        passTime++;
        remainTime--;
        if (passTime > totalTime || remainTime < 0) {
            clearInterval(timeLooper);
            $('#answer-form').submit();
            return;
        }
        $('.time-pass').html(getTime(passTime));
        $('.time-remain').html(getTime(remainTime));
    }

    /**
     * 返回时间，format hh:mm:ss
     * @param time 秒
     * @returns {string}
     */
    function getTime(time) {
        var hour = Math.floor(time / 3600);
        var min = Math.floor((time - hour * 3600) / 60);
        var sec = time - hour * 3600 - min * 60;
        return timeFormat(hour) + ':' + timeFormat(min) + ':' + timeFormat(sec);
    }

    /**
     * 数字格式化
     * @param time
     * @returns {*}
     */
    function timeFormat(time) {
        if (time < 10) {
            return '0' + time;
        } else {
            return time;
        }
    }

    //计时器
    var timeLooper = setInterval("timeCounter()", 1000);
</script>
