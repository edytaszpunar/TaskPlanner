<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<title>Register</title>

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
        <a href="/login" class="w3-bar-item w3-button w3-teal w3-right w3-hover-white"
           title="Login">Login</a>

    </div>
</div>

<div class="w3-row-padding w3-center w3-padding-64" id="register">

    <h2>Task Planner - Sign up</h2><br>
    <div class="container">
        <div class="form-group">
            <form:form modelAttribute="user" method="post">

                <label>First Name</label><br>
                <form:input path="firstName"/><br>
                <label>Last Name</label><br>
                <form:input path="lastName"/><br>
                <label>Email</label><br>
                <form:input path="email"/><br>
                <label>Login</label><br>
                <form:input path="login"/><br>
                <label>Password</label><br>
                <form:password path="password"/><br>
                <label>Confirm password</label><br>
                <input type="password" name="confirm"/><br>

                <input type="submit" value="Submit">
            </form:form>
        </div>
    </div>
</div>
</body>
</html>