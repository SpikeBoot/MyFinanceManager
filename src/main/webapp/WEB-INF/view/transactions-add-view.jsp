<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <form:form action="/transactions/saveNewUserTransaction" modelAttribute="newUserTransaction">
        Choose type transaction<br>
        from his type:<br>
        <form:select path="categoryTransaction">
            <optgroup label="Profit">
                <c:forEach var="var" items="${categoryTransactions}">
                    <c:choose>
                        <c:when test="${var.typeTransaction == true}">
                            <form:option value="${var}" label="${var.name}"/>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </optgroup>
            <optgroup label="Spend">
                <c:forEach var="var" items="${categoryTransactions}">
                    <c:choose>
                        <c:when test="${var.typeTransaction != true}">
                            <form:option value="${var}" label="${var.name}"/>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </optgroup>
        </form:select>
        <br>
        Description:
        <br>
        <form:textarea path="description"/>
        <br>
        Value:
        <br>
        <form:input path="value"/>
        <br>
        <input type="submit" value="Add">
        <input type="reset" value="Reset">
    </form:form>
</div>

</body>
</html>
