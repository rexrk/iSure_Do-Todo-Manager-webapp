<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Todo List- Todo Manager</title>
</head>
<body>
<div class="container">
    <div>
        <h1>Your Todos :</h1>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Done?</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.date}</td>
                    <td>${todo.done}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.7.1/dist/jquery.min.js"></script>
</body>
</html>