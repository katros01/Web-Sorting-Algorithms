<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <title>Books</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        header {
            background-color: #3399ff;
            padding: 15px;
            text-align: center;
            color: white;
        }

        .container {
            margin: 0px 150px 0px 150px;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: flex;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th,
        td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #3399ff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f0f0f0;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-primary {
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-danger {
            background-color: #e65f47;
        }

        button a {
            color: white;
            padding: 5px;
            text-decoration: none;
            margin-bottom: 5px;
            border-radius: 2px;
            transition: background-color 0.3s;
        }

        .btn-primary:hover {
            background-color: #45a049;
        }

        button:hover {
            background-color: #45a049;
        }

        .btn-danger:hover {
            background-color: #e85035;
        }

        .sidebar {
            position: fixed;
            width: 250px;
            height: 100%;
            background: #e9f5f3;
            border-right: 1px solid #069687;
            transition: 0.5s;
            overflow: hidden;
        }

        .sidebar ul {
            margin-top: 100px;
            left: 0;
            width: 100%;
            list-style: none;
        }

        .sidebar ul li {
            position: relative;
            width: 100%;
            padding: 10px;
            text-decoration: none;
        }

        .sidebar ul li a {
            position: relative;
            display: block;
            width: 100%;
            display: flex;
            text-decoration: none;
            color: #343a40
        }

        .sidebar ul li:hover a,
        .sidebar ul li.hovered a {
            color: #3399ff;
        }

        .sidebar ul li a .icon {
            position: relative;
            display: block;
            min-width: 60px;
            height: 60px;
            line-height: 75px;
            text-align: center;
        }

        .sidebar ul li a .icon i {
            font-size: 1.50rem;
            margin-top: 15px;
        }

        .sidebar ul li a .title {
            position: relative;
            display: block;
            padding: 0 10px;
            height: 60px;
            line-height: 60px;
            text-align: start;
            white-space: nowrap;
        }

        .content {
            flex-grow: 1;
            padding-left: 20px;
        }

        /* Additional styles for icons */
        .table a {
            display: inline-block;
            margin-right: 5px;
        }

        .table a i {
            vertical-align: middle;
        }
    </style>
    <!-- Include Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
          integrity="sha384-NpXZmZLY6AA4ISouM6UAMnLRn4HehEnpkGjJXIXNq7sEiKA3Q6l2L/tv6tT7lHbe"
          crossorigin="anonymous">
    <link rel="stylesheet" href="./style.css">
</head>

<body>

<header>
    <h2>Web Sorting Algorithms</h2>
</header>
<div class="container">

    <div class="content">
        <h3>List of Books</h3>
        <a href="<%=request.getContextPath()%>/add-book" class="btn btn-success btn-add"><button>Add New Book</button></a>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Author</th>
                <th>Genre</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
             <c:forEach items="${books}" var="bookModel">
                <tr>
                     <td>${bookModel.content.id}</td>
                     <td>${bookModel.content.name}</td>
                     <td>${bookModel.content.quantity}</td>
                     <td>${bookModel.content.author}</td>
                     <td>${bookModel.content.genre}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/edit-book?id=${book.id}" class="btn-primary">
                            <i class="fas fa-edit"></i> Edit
                        </a>
                        <a href="<%=request.getContextPath()%>/delete-book?id=${book.id}" class="btn-danger">
                            <i class="fas fa-trash-alt"></i> Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>

</html>
