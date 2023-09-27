<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
    <div>
        <h2 class="text-black mb-3">Your To-Dos</h2>
        <hr>
        <table class="table">
            <thead>
            <tr>
                <th></th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Done?</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>&#8226;</td>
                    <td>${todo.description}</td>
                    <td>${todo.date}</td>
                    <td>${todo.done}</td>
                    <td><a href="update-todo?id=${todo.id}" class="btn btn-primary btn-sm">Update</a></td>
                    <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger btn-sm">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="add-todo" class="btn btn-primary">Add Todo</a>
</div>
<%@include file="common/footer.jspf" %>