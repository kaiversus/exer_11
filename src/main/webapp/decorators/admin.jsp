<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin - <sitemesh:write property="title"/></title>
    <sitemesh:write property="head"/>
</head>
<body>
    <header>
        <h2>Trang Quản Trị</h2>
        <nav>
            <a href="<c:url value='/admin/home'/>">Dashboard</a> |
            <a href="<c:url value='/admin/category'/>">Quản lý Category</a> |
            <a href="<c:url value='/admin/user'/>">Quản lý User</a> |
            <a href="<c:url value='/home'/>">Về Trang Chủ</a>
        </nav>
    </header>
    <main>
        <sitemesh:write property="body"/>
    </main>
    <footer>
        <p>Họ tên: Đinh Thiên Bảo | MSSV: 24162009 | Mã đề: 06</p>
    </footer>
</body>
</html>