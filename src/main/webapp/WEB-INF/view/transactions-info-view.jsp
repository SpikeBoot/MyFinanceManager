<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Transaction</title>
    <link href="/resources/css/styles.css" rel="stylesheet"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

    <form:form action="/transactions/saveUserTransaction" modelAttribute="userTransaction" method="post">

        <form:hidden path="id"/>

        Choose type transaction<br>
        from his type:<br>
        <form:select path="categoryTransactionId">
            <optgroup label="Profit">
                <c:forEach var="var" items="${categoryTransactions}">
                    <c:choose>
                        <c:when test="${var.typeTransaction == true}">
                            <form:option value="${var.id}" label="${var.name}"/>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </optgroup>
            <optgroup label="Spend">
                <c:forEach var="var" items="${categoryTransactions}">
                    <c:choose>
                        <c:when test="${var.typeTransaction != true}">
                            <form:option value="${var.id}" label="${var.name}"/>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </optgroup>
        </form:select>
        <br>

        Description:
        <br>
        <form:input path="description"/>
        <br>

        Value:
        <br>
        <form:input path="value"/>
        <br>

        <input type="submit" value="Save">
        <input type="reset" value="Reset">
    </form:form>
</div>

</body>
</html>
