<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Add Todo- Todo Manager</title>
</head>
<body>
<div class="container">
    <h1>Add Todo</h1>
    <div>
        <sf:form method="post" modelAttribute="todo">
                <h3>Add Todo Details</h3>
            <label>
                Description : <sf:input type="text" path="description" required="required"/>
                <sf:errors path="description" cssClass="text-warning"/>
                <sf:input type="hidden" path="id"/>
                <sf:input type="hidden" path="done"/>
                <input type="submit" class="btn btn-success" />
            </label>
        </sf:form>
    </div>
</div>
<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.7.1/dist/jquery.min.js"></script>
</body>
</html>