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
<c:set var="SPACE1" value="<%=Command.SPACE1%>"/>
<c:set var="SPACE2" value="<%=Command.SPACE2%>"/>
<c:set var="SPACE3" value="<%=Command.SPACE3%>"/>
<c:set var="SPACE4" value="<%=Command.SPACE4%>"/>
<c:set var="DONT_PUSH_MENU" value="<%=Command.DONT_PUSH_MENU%>"/>








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


<c:if test="${command ==SPACE1&&lose!=true}">
    <h1>QUESTION1</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1call.jpg"><br>
    <p>Ты потерял память.Принять вызов НЛО?</p>
</c:if>
<c:if test="${command ==SPACE1&&lose==true}">
    <h1>Поражение</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1gameover.jpg"><br>
    <p>Ты отклонил вызов и проиграл!</p>
</c:if>


<c:if test="${command == SPACE2&&lose!=true}">
    <h1>QUESTION2</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1ufo.jpg"><br>
    <p>Ты принял вызов.Поднимаешься на мостик к капитану?</p>
</c:if>

<c:if test="${command == SPACE2&&lose==true}">
    <h1>Поражение</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1gameover.jpg"><br>
    <p>Ты не пошёл на переговоры и проиграл!</p>
</c:if>
<%--=====dont push=====--%>
<c:if test="${command == DONT_PUSH_MENU}">
    <h1>Don't push</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/dontpushmenu.jpg"><br>
</c:if>





<%--======================================--%>

<c:if test="${command == SPACE3&&lose!=true}">
    <h1>QUESTION3</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1talk.jpg"><br>
    <p>Ты поднялся на мостик.Ты кто?</p>
</c:if>
<c:if test="${command == SPACE3&&lose==true}">
    <h1>Поражение</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1gameover.jpg"><br>
    <p>Твою ложь разоблачили и ты проиграл!</p>
</c:if>

<c:if test="${command == SPACE4}">
    <h1>Победа</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1home.jpg"><br>

    <p>Тебя вернули домой.Ты победил!</p>
</c:if>




<div id="options-container">
    <form id="options-form">
        <c:if test="${command == MENU}">
            <button type="button" class="button" onclick="selectAction('game1')">Игра1</button>
            <button type="button" class="button" onclick="selectAction('game2')">Игра2</button>
            <button type="button" class="button" onclick="selectAction('game3')">Игра3</button>
            <button type="button" class="button" onclick="selectAction('game4')">Игра4</button>
        </c:if>

        <c:if test="${command == START}">
            <button type="button" class="button" onclick="selectAction('start1')">Играть</button>
        </c:if>

        <c:if test="${lose == true}">
            <button type="button" class="restart-button" onclick="restart()">Играть заново</button>
        </c:if>

        <c:if test="${command == SPACE1&&lose!= true}">
            <button type="button" class="button" onclick="selectAction('acceptCall')">Принять вызов</button>
            <button type="button" class="button" onclick="selectAction('rejectCall')">Отклонить вызов</button>
        </c:if>

        <c:if test="${command == SPACE2&&lose!= true}">
            <button type="button" class="button" onclick="selectAction('goUp')">Подняться на мостик</button>
            <button type="button" class="button" onclick="selectAction('refuseGoUp')">Не подниматься на мостик</button>
        </c:if>
        <c:if test="${command == SPACE3&&lose!= true}">
            <button type="button" class="button" onclick="selectAction('Truth')">Рассказать правду о себе</button>
            <button type="button" class="button" onclick="selectAction('Lie')">Солгать</button>
        </c:if>

        <c:if test="${command == SPACE4}">
            <button type="button" class="restart-button-win" onclick="restart()">Играть заново</button>
        </c:if>


        <c:if test="${command == DONT_PUSH_MENU}">
            <button type="button" class="button" onclick="selectAction('start2')">Играть</button>
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
