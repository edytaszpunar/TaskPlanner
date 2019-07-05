<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<title>Task Planner</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="w3-top">
    <div class="w3-bar w3-green">
        <a href="/" class="w3-bar-item w3-button w3-teal w3-hover-white">Logout</a>
        <a href="/login" class="w3-bar-item w3-button w3-teal w3-right w3-hover-white" title="Login">Login</a>
        <a href="/register" class="w3-bar-item w3-button w3-teal w3-right w3-hover-white" title="Register">Sign Up</a>
    </div>
</div>

<div class="w3-display-container w3-animate-opacity">
    <img src="<s:url value="/images/todo.jpg"/>" style="width:100%;min-height:50vh;max-height:90vh;">
</div>
</body>
</html>
