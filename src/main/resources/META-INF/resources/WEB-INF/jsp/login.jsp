<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in- Todo Manager</title>
</head>
<body>
    <div class="container">
        <h1>Todo Manager</h1>
        <form method="post">
            <div>
                <h2>Sign in</h2>
                <hr>
                <label>
                    Name : <input type="text" name="name">
                    Password : <input type="password" name="password">
                    <input type="submit" name="Log in">
                </label>
                <pre style="color: #ff0000">${errMessage}</pre>
            </div>
        </form>
    </div>
</body>
</html>
