<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:directive.page contentType="text/html;charset=UTF-8"/>
<html>
<head><title>Transactions List</title>
    <jsp:include page="includeFile.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navigationUserBar.jsp"></jsp:include>
<div class="container">
    <h1><fmt:message key = "ListOfTransactions"/></h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <td><fmt:message key = "Index"/></td>
            <td><fmt:message key = "Date"/></td>
            <td><fmt:message key = "Sum"/></td>
            <td><fmt:message key = "TypeOfTransaction"/></td>
            <td><fmt:message key = "CardNumber"/></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tr" items="${transactions}" varStatus="status">
            <tr>
                <td><c:out value="${status.index + 1}"/></td>
                <td><c:out value="${tr.trDate}"/></td>
                <td><c:out value="${tr.trSum}"/></td>
                <c:if test="${tr.trType == 0}">
                    <td>Payment was made</td>
                </c:if>
                <c:if test="${tr.trType == 1}">
                    <td>Adding funds was made</td>
                </c:if>
                <td><c:out value="${cardNumbers[status.index]}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div style="color: red"><c:out value="${error}"/></div>
</body>
</html>
