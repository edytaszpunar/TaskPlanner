<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show Comments</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="w3-top">
    <div class="w3-bar w3-green">
        <a href="/" class="w3-bar-item w3-button w3-teal w3-hover-white">Logout</a>
        <a href="/user/manage" class="w3-bar-item w3-button w3-teal w3-hover-white">Manage</a>
    </div>
</div>


<div class="w3-container w3-center"><br><br>
    <h2>Comments</h2>
</div>

<div class="w3-display-container w3-section" style="height:40%">
    <table class="w3-table-all w3-display-middle" style="width:50%">

        <thead>
        <tr class="w3-teal">
            <th>Task Name</th>
            <th>Comment Text</th>
        </tr>
        </thead>
        <c:forEach var="comment" items="${comments}">
            <tr>
                <td><c:out value="${comment.task.name}"/></td>
                <td><c:out value="${comment.comment}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
