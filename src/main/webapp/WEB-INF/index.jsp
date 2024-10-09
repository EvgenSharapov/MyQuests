<%@ page import="servlets.Command" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Text Quest</title>
    <link rel="stylesheet" type="text/css" href="../static/my.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<c:set var="MENU" value="<%=Command.MENU%>"/>
<c:set var="START" value="<%=Command.START%>"/>
<c:set var="QUESTION1" value="<%=Command.QUESTION1%>"/>
<c:set var="QUESTION2" value="<%=Command.QUESTION2%>"/>
<c:set var="QUESTION3" value="<%=Command.QUESTION3%>"/>
<c:set var="QUESTION4" value="<%=Command.QUESTION4%>"/>

<c:if test="${command == MENU}">
    <h1>Главное меню</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/startPage.jpg"><br>
</c:if>


<c:if test="${command == START}">
    <h1>Space Quest</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/start1q.jpg"><br>
</c:if>





<c:if test="${command ==QUESTION1&&dead!=true}">
    <h1>QUESTION1</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1call.jpg"><br>
    <p>Ты потерял память.Принять вызов НЛО?</p>
</c:if>
<c:if test="${command ==QUESTION1&&dead==true}">
    <h1>Поражение</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1gameover.jpg"><br>
    <p>Ты отклонил вызов и проиграл!</p>
</c:if>


<c:if test="${command == QUESTION2&&dead!=true}">
    <h1>QUESTION2</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1ufo.jpg"><br>
    <p>Ты принял вызов.Поднимаешься на мостик к капитану?</p>
</c:if>

<c:if test="${command == QUESTION2&&dead==true}">
    <h1>Поражение</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1gameover.jpg"><br>
    <p>Ты не пошёл на переговоры и проиграл!</p>
</c:if>


<c:if test="${command == QUESTION3&&dead!=true}">
    <h1>QUESTION3</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1talk.jpg"><br>
    <p>Ты поднялся на мостик.Ты кто?</p>
</c:if>
<c:if test="${command == QUESTION3&&dead==true}">
    <h1>Поражение</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1gameover.jpg"><br>
    <p>Твою ложь разоблачили и ты проиграл!</p>
</c:if>

<c:if test="${command == QUESTION4}">
    <h1>Победа</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1home.jpg"><br>

    <p>Тебя вернули домой.Ты победил!</p>
</c:if>




<div id="options-container">
    <form id="options-form">
        <c:if test="${command == MENU}">
            <button type="button" class="button" onclick="selectAction('game1')">Игра1</button>
        </c:if>

        <c:if test="${command == START}">
            <button type="button" class="button" onclick="selectAction('start')">Играть</button>
        </c:if>

        <c:if test="${dead == true}">
            <button type="button" class="restart-button" onclick="restart()">Играть заново</button>
        </c:if>

        <c:if test="${command == QUESTION1&&dead != true}">
            <button type="button" class="button" onclick="selectAction('acceptCall')">Принять вызов</button>
            <button type="button" class="button" onclick="selectAction('rejectCall')">Отклонить вызов</button>
        </c:if>

        <c:if test="${command == QUESTION2&&dead != true}">
            <button type="button" class="button" onclick="selectAction('goUp')">Подняться на мостик</button>
            <button type="button" class="button" onclick="selectAction('refuseGoUp')">Не подниматься на мостик</button>
        </c:if>
        <c:if test="${command == QUESTION3&&dead != true}">
            <button type="button" class="button" onclick="selectAction('Truth')">Рассказать правду о себе</button>
            <button type="button" class="button" onclick="selectAction('Lie')">Солгать</button>
        </c:if>

        <c:if test="${command == QUESTION4}">
            <button type="button" class="restart-button-win" onclick="restart()">Играть заново</button>
        </c:if>
    </form>
</div>

<script>





    function restart() {
        $.ajax({
            url: '/restart',
            type: 'POST',
            async: false,
            success: function () {
                location.reload();
            }
        });
    }

    function selectAction(action) {
        $.ajax({
            type: 'POST',
            url: 'start',
            data: { action: action },
            success: function() {
                location.reload();
            }
        });
    }

</script>

</body>
</html>
