<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2/20/2023
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Quản lý khách hàng</title>
</head>
<body>
<h1>Thêm mới khách hàng</h1>
<p><a href="<c:url value="/students"/>">Danh sách khách hàng</a></p>

<form action="<c:url value="/student/add"/>" method="post">
    <label>Id: </label><br/>
    <input type="text" name="id" value="${students.id}"/><br/>
    <label>Họ tên: </label><br/>
    <input type="text" name="name" value="${students.name}"/><br/>
    <label>Địa chỉ: </label><br/>
    <input type="text" name="address" value="${students.address}"/><br>
    <label>Email: </label><br/>
    <input type="text" name="email" value="${students.email}"/><br/>
    <label>phone </label><br/>
    <input type="text" name="phone" value="${students.phone}"/><br>
    <br/><br/>
    <button type="submit" class="btn btn-success">Lưu lại</button>
</form>
<p>
    ${message}
</p>
</body>
</html>
