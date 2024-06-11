<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

        <h1>CREATE TODO</h1>
        <form:form method="post" modelAttribute="todo">
          <div class="form-group mb-3">
            <label class="mb-1" for="description">Description</label>
            <form:input class="form-control" path="description" id="description" placeholder="Enter Description"
              required="required" />

            <small id="description" class="form-text text-danger px-2 pt-1">
              <form:errors path="description" />
            </small>
          </div>

          <form:input type="hidden" path="id" class="form-control" />
          <form:input type="hidden" path="done" class="form-control" />
          <input type="submit" class="btn btn-primary" />
        </form:form>

      </div>
      <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
      <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>

    </html>