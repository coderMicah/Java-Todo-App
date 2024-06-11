<%@ taglib prefix="c" uri="jakarta.tags.core" %>

    <html>

    <head>
        <title>Todos Page</title>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <h2>Welcome ${name}</h2>
            <hr>

            <h1>TODOS</h1>

            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td> <a href="delete-todo?id=${todo.id}" class="btn btn-danger">DELETE</a></td>
                            <td> <a href="update-todo?id=${todo.id}" class="btn btn-warning">UPDATE</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <a href="/add-todo" class="btn btn-success">Create Todo</a>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>

    </html>