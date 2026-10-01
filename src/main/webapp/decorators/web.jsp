<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><sitemesh:write property="title"/></title>
    <sitemesh:write property="head"/>
</head>
<body>
    <header>
        <nav>
            <a href="<c:url value='/home'/>">Trang Chủ</a> |
            <a href="<c:url value='/products'/>">Sản phẩm</a> |
            <c:if test="${empty sessionScope.account}">
                <a href="<c:url value='/login'/>">Đăng nhập</a>
            </c:if>
            <c:if test="${not empty sessionScope.account}">
                <span>Xin chào ${sessionScope.account.fullname}</span> |
                <a href="<c:url value='/cart'/>">Giỏ hàng</a> |
                <a href="<c:url value='/order-history'/>">Lịch sử đơn hàng</a> |
                <a href="<c:url value='/logout'/>">Đăng xuất</a> |
                <c:if test="${sessionScope.account.roleId == 1}">
                    <a href="<c:url value='/admin/home'/>">Trang quản trị</a>
                </c:if>
            </c:if>
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