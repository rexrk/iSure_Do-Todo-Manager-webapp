<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
    <h2 class="mb-3">Todo Manager</h2>
    <form method="post">
        <div>
            <h5 class="text-bg-dark col-md-1 text-center">Sign in</h5>
            <hr>
            Name : <input type="text" name="name">
            Password : <input type="password" name="password">
            <input type="submit" name="Log in">
            <pre style="color: #ff0000">${errMessage}</pre>
        </div>
    </form>
</div>
<%@include file="common/footer.jspf" %>