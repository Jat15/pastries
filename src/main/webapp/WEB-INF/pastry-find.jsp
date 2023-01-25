<%--
  Created by IntelliJ IDEA.
  User: JatMuadDib
  Date: 24/01/2023
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pastry List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="container">
<header class="row">
    <%@ include file="nav.jsp"%>
    <h1>Pastry list</h1>
</header>
<main class="row row-cols-2 row-cols-lg-4">




    <c:forEach items="${pastryList}" var="pastry">
      <div class="card col p-3 m-3">
        <img class="card-img-top" alt="${pastry.name}"
             src="https://sauvageboris.fr/training/api/pastries/images/${pastry.img}">
        <div class="card-body"><h5 class="card-title">${pastry.name}</h5>
            <p class="card-text overflow-y-scroll pastry-height-25">${pastry.description}</p>
          <a class="btn btn-primary" data-bcup-haslogintext="no" href="${pageContext.request.contextPath}/pastry-delete?id=${pastry.id}">Click</a></div>
      </div>
    </c:forEach>



</main>
<%@ include file="footer.jsp"%>
</body>
</html>
