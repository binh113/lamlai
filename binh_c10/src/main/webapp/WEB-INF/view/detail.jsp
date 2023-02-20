<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2/20/2023
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Quản lý khách hàng</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<p><a href="<c:url value="/students"/>">Danh sách khách hàng</a></p>

<p><b>Mã số:</b> ${students.id}</p>
<p><b>Họ tên:</b> ${students.name}</p>
<p><b>dob:</b> ${students.dob}</p>
<p><b>Địa chỉ:</b> ${students.address}</p>
<p><b>phone:</b> ${students.phone}</p>
<p><b>Email:</b> ${students.email}</p>
<p><b>class:</b> ${students.classRoom}</p>

</body>
</html>