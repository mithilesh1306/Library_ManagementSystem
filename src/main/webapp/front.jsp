<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Book Registration</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">

  <style>
    body {
      background: linear-gradient(to right, #00b4db, #0083b0);
      font-family: 'Poppins', sans-serif;
      color: #333;
      min-height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
      padding: 20px;
    }

    .card {
      border: none;
      border-radius: 20px;
      box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
    }

    .card-title {
      color: #0062cc;
      font-weight: 600;
    }

    .btn-primary {
      background-color: #0062cc;
      border: none;
    }

    .btn-primary:hover {
      background-color: #004ea2;
    }

    .btn-success {
      background-color: #28a745;
      border: none;
    }

    .btn-success:hover {
      background-color: #218838;
    }

    @media (max-width: 576px) {
      .btn-group-responsive {
        flex-direction: column;
        gap: 10px;
      }
    }
  </style>
</head>
<body>

  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-6 col-md-8">
        <div class="card p-4">
          <h2 class="text-center card-title mb-4">📚 Book Registration</h2>

          <form action="index" method="post">
            <div class="mb-3">
              <label for="bookName" class="form-label">Book Name</label>
              <input type="text" class="form-control" id="bookName" placeholder="Enter book name" name="name" required>
            </div>

            <div class="mb-3">
              <label for="bookEdition" class="form-label">Book Edition</label>
              <input type="text" class="form-control" id="bookEdition" placeholder="Enter book edition" name="edition" required>
            </div>

            <div class="mb-3">
              <label for="bookPrice" class="form-label">Book Price</label>
              <input type="number" class="form-control" id="bookPrice" placeholder="Enter book price" name="price" required>
            </div>

            <div class="d-flex flex-wrap justify-content-between align-items-center btn-group-responsive">
              <button class="btn btn-primary mb-2" type="submit">Submit</button>
              <a href="index.html" class="btn btn-warning mb-2">Back</a>
              <a href="booklist" class="btn btn-success mb-2">View Book List</a>
            </div>
          </form>

        </div>
      </div>
    </div>
  </div>

</body>
</html>
