<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Transactions</title>
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

<div class="transactionPanel">
    <%--Panel of control--%>
    <div class="transactionControl">
        <a href="/transactions/addTransaction" class="transControlButton">Add</a>
        <a href="/" class="transControlButton">Edit</a>
        <a href="/" class="transControlButton">Delete</a>
    </div>

    <%--Transaction table--%>
    <div class="transactionView">
        <table class="transactionTable">
            <tr>
                <th></th>
                <th>Category</th>
                <th>Description</th>
                <th>Date</th>
                <th>Value</th>
            </tr>
            <c:if test="${!empty userTransactions}">
                <c:forEach var="userTransaction" items="${userTransactions}">
                    <c:choose>
                        <c:when test="${userTransaction.typeTransaction == true}">
                            <tr style="background-color: #C6EFCE">
                                <td class="tdcheckbox"><input type="checkbox" name="${userTransaction.id}"></td>
                                <td class="tdText">${userTransaction.categoryTransaction.name}</td>
                                <td class="tdText">${userTransaction.description}</td>
                                <td class="tdText">DATE</td>
                                <td class="tdValue">${userTransaction.value}</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <tr style="background-color: #FFC7CE">
                                <td class="tdcheckbox"><input type="checkbox" name="${userTransaction.id}"></td>
                                <td class="tdText">${userTransaction.categoryTransaction.name}</td>
                                <td class="tdText">${userTransaction.description}</td>
                                <td class="tdText">DATE</td>
                                <td class="tdValue">${userTransaction.value}</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </c:forEach></c:if>
        </table>
    </div>
</div>

</body>
</html>
