<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List- Todo Manager</title>
</head>
<body>
    <h1>Hey ${name}</h1>
<hr>
<div>
    <h1>Your Todos :</h1>
    <div>
        <table>
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
</div>

</body>
</html>