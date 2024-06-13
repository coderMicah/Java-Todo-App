<html>

<head>
  <title>Login</title>
  <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="flex justify-center items-center">
  <div class="container">
    <h1 class="h3 mb-3 font-weight-normal">Login</h1>

    <pre>${errorMessage}</pre>
    <form class="mx-auto" method="post">
      <div class="form-outline mb-4">
        <label for="name">Name</label>
        <input type="text" name="name" class="form-control" id="name" aria-describedby="username"
          placeholder="Enter Username">

      </div>
      <div class="form-outline mb-4">
        <label for="password">Password</label>
        <input type="password" name="password" class="form-control" id="password" placeholder="Password">
      </div>

      <input type="submit" class="btn btn-primary" />
    </form>
  </div>
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>

</html>