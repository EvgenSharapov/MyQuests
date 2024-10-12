<%@ page import="servlets.Command" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Text Quest</title>
    <link rel="stylesheet" type="text/css" href="../static/my.css">

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
<c:set var="JAVA_RUSH" value="<%=Command.JAVA_RUSH%>"/>
<c:set var="QUESTION1" value="<%=Command.QUESTION1%>"/>
<c:set var="QUESTION2" value="<%=Command.QUESTION2%>"/>
<c:set var="QUESTION3" value="<%=Command.QUESTION3%>"/>
<c:set var="QUESTION4" value="<%=Command.QUESTION4%>"/>
<c:set var="QUESTION5" value="<%=Command.QUESTION5%>"/>



<c:if test="${command == MENU}">
    <div class="stage">
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>
        <div class="layer"></div>


    <style>
        * *, *::before, *::after {
            animation-play-state: running !important;
        }
    </style>
    </div>
    <c:if test="${username ==null}">
    <div>
    <img class="image-menu"
         src="${pageContext.request.contextPath}/static/image/startPage.jpg">
    <input class="login" type="text" id="name" name="name" placeholder="Введите своё имя" maxlength="20" value="" required >
    <button type="button"  class="button-login-enter" onclick="setName(document.getElementsByClassName('login')[0].value)">Вход</button>
    </div>
    </c:if>
    <c:if test="${username !=null}">
        <div>
            <img class="image-menu"
                 src="${pageContext.request.contextPath}/static/image/startPage.jpg">
            <b class="login-text"><%=session.getAttribute("username")%></b>
            <button type="button" class="button-login-enter" onclick="restart()">Выход</button>
        </div>
    </c:if>

</c:if>


<c:if test="${command == START}">
    <h1>Space Quest</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/start1q.jpg"><br>
</c:if>


<c:if test="${command ==SPACE1&&lose!=true}">
    <h1>Ты потерял память.Принять вызов НЛО?</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1call.jpg"><br>
</c:if>
<c:if test="${command ==SPACE1&&lose==true}">
    <h1>Ты отклонил вызов и проиграл!</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1gameover.jpg"><br>
</c:if>


<c:if test="${command == SPACE2&&lose!=true}">
    <h1>Ты принял вызов.Поднимаешься на мостик к капитану?</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1ufo.jpg"><br>
</c:if>

<c:if test="${command == SPACE2&&lose==true}">
    <h1>Ты не пошёл на переговоры и проиграл!</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1gameover.jpg"><br>
</c:if>
<%--=====dont push=====--%>
<c:if test="${command == DONT_PUSH_MENU}">
    <h1>Don't push</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/dontpushmenu.jpg"><br>
    <button type="button" class="button" onclick="restart()">Главное меню</button>


    <%--=====java rush=====--%>
</c:if>
<c:if test="${command == JAVA_RUSH}">
    <h1>Java Rush Test</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/rush/java_menu.jpg"><br>
    <button type="button" class="button" onclick="selectAction('start4')">Пройти тест</button>
    <button type="button" class="button" onclick="restart()">Главное меню</button>
</c:if>
<c:if test="${command == QUESTION1}">
  <h1>В языке Java выполнение программы начинается с метода...</h1>
<div class="div1">
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/rush/rushq1.jpg">
    <div class="div2">
        <div class="btn-group">
           <b>Правильных ответов: <%=(int)session.getAttribute("score")%></b><br>
            <b>Выбери один из вариантов:</b>
        <button type="button" class="button-r" onclick="selectAction('quest1_1')">begin()</button>
        <button type="button" class="button-r" onclick="selectAction('quest1_1')">start()</button>
        <button type="button" class="button-r" onclick="selectAction('quest1_1')">run()</button>
        <button type="button" class="button-r" onclick="selectAction('quest1_2')">main()</button>
    </div>
    </div>
</div>
    <button type="button" class="button" onclick="restart()">Главное меню</button>
</c:if>


<c:if test="${command == QUESTION2}">
    <h1>В языке Java вывести текст на экран в несколько строк можно с помощью функции...</h1>
    <div class="div1">
        <img class="rounded mx-auto d-block"
             src="${pageContext.request.contextPath}/static/image/rush/rushq2.jpg">
        <div class="div2">
            <div class="btn-group">
                <b>Правильных ответов: <%=(int)session.getAttribute("score")%></b><br>
                <b>Выбери один из вариантов:</b>
                <button type="button" class="button-r" onclick="selectAction('quest2_1')">print()</button>
                <button type="button" class="button-r" onclick="selectAction('quest2_2')">println()</button>
                <button type="button" class="button-r" onclick="selectAction('quest2_1')">printLine()</button>
                <button type="button" class="button-r" onclick="selectAction('quest2_1')">printLines()</button>
            </div>
        </div>
    </div>
    <button type="button" class="button" onclick="restart()">Главное меню</button>
</c:if>

<c:if test="${command == QUESTION3}">
    <h1>В языке Java объявить переменную name можно с помощью команды...</h1>
    <div class="div1">
        <img class="rounded mx-auto d-block"
             src="${pageContext.request.contextPath}/static/image/rush/rushq3.jpg">
        <div class="div2">
            <div class="btn-group">
                <b>Правильных ответов: <%=(int)session.getAttribute("score")%></b><br>
                <b>Выбери один из вариантов:</b>
                <button type="button" class="button-r" onclick="selectAction('quest3_1')">var name;</button>
                <button type="button" class="button-r" onclick="selectAction('quest3_2')">String name;</button>
                <button type="button" class="button-r" onclick="selectAction('quest3_1')">var name:String</button>
                <button type="button" class="button-r" onclick="selectAction('quest3_1')">name:String</button>
            </div>
        </div>
    </div>
    <button type="button" class="button" onclick="restart()">Главное меню</button>
</c:if>

<c:if test="${command == QUESTION4}">
    <h1>В языке Java многострочный комментарий начинается/создаётся с помощью символов...</h1>
    <div class="div1">
        <img class="rounded mx-auto d-block"
             src="${pageContext.request.contextPath}/static/image/rush/rushq4.jpg">
        <div class="div2">
            <div class="btn-group">
                <b>Правильных ответов: <%=(int)session.getAttribute("score")%></b><br>
                <b>Выбери один из вариантов:</b>
                <button type="button" class="button-r" onclick="selectAction('quest4_1')">--</button>
                <button type="button" class="button-r" onclick="selectAction('quest4_1')">//</button>
                <button type="button" class="button-r" onclick="selectAction('quest4_2')">/*</button>
                <button type="button" class="button-r" onclick="selectAction('quest4_1')">///</button>
            </div>
        </div>
    </div>
    <button type="button" class="button" onclick="restart()">Главное меню</button>
</c:if>

<c:if test="${command == QUESTION5}">
    <h1>Java-компилятор после компиляции выдаёт...</h1>
    <div class="div1">
        <img class="rounded mx-auto d-block"
             src="${pageContext.request.contextPath}/static/image/rush/rushq5.jpg">
        <div class="div2">
            <div class="btn-group">
                <b>Правильных ответов: <%=(int)session.getAttribute("score")%></b><br>
                <b>Выбери один из вариантов:</b>
                <button type="button" class="button-r" onclick="selectAction('quest4_1')">программу, состоящую из машинных кодов</button>
                <button type="button" class="button-r" onclick="selectAction('quest4_1')">программу, состоящую из байт-кодов</button>
                <button type="button" class="button-r" onclick="selectAction('quest4_2')">архив с файлами из машинных кодов</button>
                <button type="button" class="button-r" onclick="selectAction('quest4_1')">архив с файлами из байт-кода</button>
            </div>
        </div>
    </div>
    <button type="button" class="button" onclick="restart()">Главное меню</button>
</c:if>


<%--======================================--%>

<c:if test="${command == SPACE3&&lose!=true}">
    <h1>Ты поднялся на мостик.Ты кто?</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1talk.jpg"><br>
</c:if>
<c:if test="${command == SPACE3&&lose==true}">
    <h1>Твою ложь разоблачили и ты проиграл!</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1gameover.jpg"><br>
</c:if>

<c:if test="${command == SPACE4}">
    <h1>Тебя вернули домой.Ты победил!</h1>
    <img class="rounded mx-auto d-block"
         src="${pageContext.request.contextPath}/static/image/q1home.jpg"><br>

</c:if>




<div id="options-container">
    <form id="options-form">
        <c:if test="${command == MENU}">
            <button type="button" class="button" onclick="selectAction('game1')">Space Quest</button>
            <button type="button" class="button" onclick="selectAction('game2')">Игра2</button>
            <button type="button" class="button" onclick="selectAction('game3')">Игра3</button>
            <button type="button" class="button" onclick="selectAction('game4')">Java Rush</button>
        </c:if>

        <c:if test="${command == START}">
            <button type="button" class="button" onclick="selectAction('start1')">Играть</button>
            <button type="button" class="button" onclick="restart()">Главное меню</button>
        </c:if>

        <c:if test="${lose == true}">
            <button type="button" class="restart-button" onclick="restart()">Главное меню</button>
        </c:if>

        <c:if test="${command == SPACE1&&lose!= true}">
            <button type="button" class="button" onclick="selectAction('acceptCall')">Принять вызов</button>
            <button type="button" class="button" onclick="selectAction('rejectCall')">Отклонить вызов</button>
        </c:if>

        <c:if test="${command == SPACE2&&lose!= true}">
            <button type="button" class="button" onclick="selectAction('refuseGoUp')">Не подниматься на мостик</button>
            <button type="button" class="button" onclick="selectAction('goUp')">Подняться на мостик</button>
        </c:if>
        <c:if test="${command == SPACE3&&lose!= true}">
            <button type="button" class="button" onclick="selectAction('Truth')">Рассказать правду о себе</button>
            <button type="button" class="button" onclick="selectAction('Lie')">Солгать</button>
        </c:if>

        <c:if test="${command == SPACE4}">
            <button type="button" class="restart-button-win" onclick="restart()">Главное меню</button>
            <button type="button" class="restart-button-win" onclick="selectAction('game1')">Меню игры</button>
            <button type="button" class="restart-button-win" onclick="selectAction('start1')">Играть заново</button>
        </c:if>


        <c:if test="${command == DONT_PUSH_MENU}">
            <button type="button" class="button" onclick="selectAction('start2')">Играть</button>
        </c:if>


    </form>
</div>

<script>
    window.setTimeout = null;




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
    function setName(name) {
        $.ajax({
            type: 'POST',
            url: 'start',
            data: { name: name },
            success: function() {
                location.reload();
            }
        });

    }

</script>

</body>
</html>
