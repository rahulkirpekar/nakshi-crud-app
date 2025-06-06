<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Students</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 50px;
        }
        .table-container {
            background-color: white;
            padding: 20px 40px;
            border-radius: 10px;
            width: 800px;
            margin: auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            text-align: center;
            padding: 10px;
            border: 1px solid #ccc;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        h2 {
            text-align: center;
        }
        .btn {
            padding: 6px 12px;
            color: white;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
        }
        .btn-edit {
            background-color: #2196F3;
        }
        .btn-edit:hover {
            background-color: #1976D2;
        }
        .btn-delete {
            background-color: #f44336;
        }
        .btn-delete:hover {
            background-color: #d32f2f;
        }
        .action-buttons a {
            margin: 0 5px;
        }
    </style>
</head>
<body>

<div class="table-container">
    <h2>List of Student Records</h2>

    <%
        ArrayList<StudentBean> list = (ArrayList<StudentBean>) request.getAttribute("list");
    %>

    <table>
        <tr>
            <th>Rno</th>
            <th>Name</th>
            <th>Std</th>
            <th>Marks</th>
            <th>Action</th>
        </tr>

        <%
            for (int i = 0; i < list.size(); i++) {
                StudentBean s = list.get(i);
        %>
        <tr>
            <td><%= s.getRno() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getStd() %></td>
            <td><%= s.getMarks() %></td>
            <td class="action-buttons">
                <a class="btn btn-edit" href="EditStudentServlet?rno=<%= s.getRno() %>">Edit</a>
                <a class="btn btn-delete" href="DeleteStudentServlet?rno=<%= s.getRno() %>">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
</div>

</body>
</html>
