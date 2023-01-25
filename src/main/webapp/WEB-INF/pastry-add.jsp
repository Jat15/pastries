<%--
  Created by IntelliJ IDEA.
  User: JatMuadDib
  Date: 25/01/2023
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pastry Add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="container">
<header class="row">
    <%@ include file="nav.jsp"%>
    <h1 class="col-12 text-center">Pastry add</h1>
</header>
<main class="row">

    <form action="${pageContext.request.contextPath}/pastry-add" method="post">
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Name" aria-label="Name" name="name" required>
        </div>
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Description" aria-label="Description" name="description" required>
        </div>
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Image" aria-label="Image" name="img" required>
        </div>

        <div class="text-center mb-3">
            <button type="submit" class="btn btn-primary">Add</button>
        </div>



    </form>

</main>

<%@ include file="footer.jsp"%>
</body>
</html>
