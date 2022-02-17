<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SpikeBoot
  Date: 17.02.2022
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All Category Transaction</title>
</head>
<body>
<h2>Category Transaction</h2>
<br>
<table>
    <tr>
        <th>Type trans.</th>
        <th>Name trans.</th>
    </tr>


    <c:forEach var="catTrans" items="${allCategoryTransactions}">
        <tr>
            <td>${catTrans.typeTransaction}</td>
            <td>${catTrans.name}</td>
        </tr>
    </c:forEach>


</table>


</body>
</html>
