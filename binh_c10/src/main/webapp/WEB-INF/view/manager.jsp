<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2/20/2023
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Danh sách student</h1>
<p><a href="<c:url value="/students"/>">back tp home page</a></p>
<p><a href="<c:url value="/student/add"/>">Thêm mới</a></p>
<form action="<c:url value="/student/searchByName"/>" method="get">
    <input type="text" name="name" placeholder="search name">
    <input type="submit" value="submit">
</form>
<table border="1">
    <thead>
    <tr>
        <th>Mã số</th>
        <th> tên</th>
        <th>dia chi</th>
        <th>lop</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.address}</td>
            <td>${student.classRoom}</td>
            <td>
                <a href="<c:url value="/student/detail"/>?id=${student.id}">detail</a> |
                <a href="<c:url value="/student/edit"/>?id=${student.id}">edit</a> |
                <a href="<c:url value="/student/remove"/>?id=${student.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
