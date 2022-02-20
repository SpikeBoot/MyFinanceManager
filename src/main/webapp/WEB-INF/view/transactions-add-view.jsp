<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Transaction</title>
    <link href="/resources/css/styles.css" rel="stylesheet"/>

</head>
<body>

<%--Menu--%>
<div class="navigationPanel">
    <p class="label">My<br>Finance<br>Manager</p>
    <a href="/transactions/view" class="navigationButton">Transactions</a><br>
    <a href="/" class="navigationButton">Statistic</a><br>
    <a href="/" class="navigationButton">Settings</a><br>
    <a href="/" class="navigationButton">Help</a><br>
</div>

<%--Panel of adding transaction--%>
<div class="addPanel">

    <form:form action="/transactions/view" modelAttribute="newUserTransaction">
        <h4>Type transaction:</h4><br>


    </form:form>
</div>

</body>
</html>
