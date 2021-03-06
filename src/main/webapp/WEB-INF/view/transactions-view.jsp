<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Transactions</title>
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

<div class="transactionPanel">
    <%--Panel of control--%>
    <div class="transactionControl">
        <a href="/transactions/addTransaction" class="transControlButton">Add</a>
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
                <c:forEach var="var" items="${userTransactions}">
                    <c:choose>
                        <c:when test="${var.categoryTransaction.typeTransaction == true}">

                            <c:url var="updateButton" value="/transactions/updateTransaction">
                                <c:param name="transactionId" value="${var.id}"/>
                            </c:url>

                            <c:url var="deleteButton" value="/transactions/deleteTransaction">
                                <c:param name="transactionId" value="${var.id}"/>
                            </c:url>

                            <tr style="background-color: #C6EFCE">
                                <td>
                                    <a href="${updateButton}" class="manipulationButton">Update</a>
                                    <a href="${deleteButton}" class="manipulationButton">Delete</a>
                                </td>
                                <td class="tdText">${var.categoryTransaction.name}</td>
                                <td class="tdText">${var.description}</td>
                                <td class="tdText">DATE</td>
                                <td class="tdValue">${var.value}</td>
                            </tr>
                        </c:when>
                        <c:otherwise>

                            <c:url var="updateButton" value="/transactions/updateTransaction">
                                <c:param name="transactionId" value="${var.id}"/>
                            </c:url>

                            <c:url var="deleteButton" value="/transactions/deleteTransaction">
                                <c:param name="transactionId" value="${var.id}"/>
                            </c:url>

                            <tr style="background-color: #FFC7CE">
                                <td>
                                    <a href="${updateButton}" class="manipulationButton">Update</a>
                                    <a href="${deleteButton}" class="manipulationButton">Delete</a>
                                </td>
                                <td class="tdText">${var.categoryTransaction.name}</td>
                                <td class="tdText">${var.description}</td>
                                <td class="tdText">DATE</td>
                                <td class="tdValue">${var.value}</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:if>
        </table>
    </div>
</div>

</body>
</html>
