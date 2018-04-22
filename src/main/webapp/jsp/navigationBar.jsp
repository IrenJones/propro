<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:directive.page contentType="text/html;charset=UTF-8"/>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">PaymentsApp</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav" style="float: none!Important;">
            <li><a href="/simpleProject/home">Home</a></li>
            <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage
                    <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="/simpleProject/show_items">Manage Items</a></li>
                      <li><a href="/simpleProject/show_carts">Manage Carts</a></li>
                    </ul>
             </li>
            <li><a href="/simpleProject/addItemToCart">Add Item To Cart</a></li>
            <li><a href="/simpleProject/allCartsWithItems">Show All Carts With Items</a></li>
          </ul>
        </div>
  </div>
</div>
<br><br>
<br>
