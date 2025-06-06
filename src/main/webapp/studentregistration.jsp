<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 50px;
        }
        .form-container {
            background-color: white;
            padding: 20px 40px;
            border-radius: 10px;
            width: 400px;
            margin: auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Student Registration</h2>
    <form action="InsertStudentServlet" method="post">
        <label for="name">Student Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="std">Standard (Std):</label>
        <input type="text" id="std" name="std" required>

        <label for="marks">Marks:</label>
        <input type="number" id="marks" name="marks" min="0" max="100" required>

        <input type="submit" value="Register">
    </form>
</div>

</body>
</html>
