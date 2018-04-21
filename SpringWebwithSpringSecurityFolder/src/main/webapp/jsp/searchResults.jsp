<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:directive.page contentType="text/html;charset=UTF-8"/>
<html>
  <head><title>Search Results</title>
    <jsp:include page="includeFile.jsp"></jsp:include>
  </head>
  <body>
  <jsp:include page="navigationAdminBar.jsp"></jsp:include>
    <div class="container">
    <h1><fmt:message key = "SearchRes"/></h1>
    <c:if test="${user != null}">
        <table class="table table-hover" style="width:40%">
        <thead>
           </thead>
           <tbody>
           <tr>
           <td><fmt:message key = "ID"/></td>
           <td><c:out value="${user.id}"/></td>
            <tr>
            <td><fmt:message key = "Login"/></td>
            <td><c:out value="${user.login}"/></td>
            </tr>
            <tr>
            <td><fmt:message key = "Role"/></td>
            <td><c:out value="${user.isAdmin}"/></td>
            </tr>
          </tbody>
        </table>
     </c:if>
        <div style="color: red"><c:out value="${error}"/></div>
    </div>
  </body>
</html>