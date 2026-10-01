<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng - 24162009 Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="<c:url value='/home'/>">24162009 Store</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/home'/>">Trang Chủ</a></li>
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/products'/>">Sản phẩm</a></li>
                </ul>
                <ul class="navbar-nav">
                    <c:if test="${not empty sessionScope.account}">
                        <li class="nav-item"><span class="nav-link text-light">Xin chào, ${sessionScope.account.fullname}</span></li>
                        <li class="nav-item"><a class="nav-link active" href="<c:url value='/cart'/>">Giỏ hàng</a></li>
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/order-history'/>">Lịch sử đơn hàng</a></li>
                        <c:if test="${sessionScope.account.roleId == 1}">
                            <li class="nav-item"><a class="nav-link" href="<c:url value='/admin/home'/>">Trang quản trị</a></li>
                        </c:if>
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/logout'/>">Đăng xuất</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container my-4 flex-grow-1">
        <h3 class="mb-4">Giỏ hàng của bạn</h3>
        <c:choose>
            <c:when test="${empty cartItems}">
                <div class="alert alert-info">Giỏ hàng trống. <a href="<c:url value='/products'/>">Tiếp tục mua sắm</a></div>
            </c:when>
            <c:otherwise>
                <table class="table table-bordered">
                    <thead class="table-light">
                        <tr>
                            <th>Sản phẩm</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Tổng</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${cartItems}">
                            <tr>
                                <td>${item.product.productName}</td>
                                <td>${item.unitPrice}</td>
                                <td>
                                    <form action="<c:url value='/cart/update'/>" method="post" class="d-flex gap-2">
                                        <input type="hidden" name="cartItemId" value="${item.cartItemId}">
                                        <input type="number" name="quantity" value="${item.quantity}" min="1" max="${item.product.stock}" class="form-control" style="width: 80px;">
                                        <button type="submit" class="btn btn-sm btn-primary">Cập nhật</button>
                                    </form>
                                </td>
                                <td>${item.unitPrice * item.quantity}</td>
                                <td>
                                    <form action="<c:url value='/cart/remove'/>" method="post">
                                        <input type="hidden" name="cartItemId" value="${item.cartItemId}">
                                        <button type="submit" class="btn btn-sm btn-danger">Xóa</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <th colspan="3" class="text-end">Tổng cộng:</th>
                            <th colspan="2" class="text-danger">${totalPrice} VNĐ</th>
                        </tr>
                    </tfoot>
                </table>
                <div class="d-flex justify-content-end gap-2 mt-3">
                    <a href="<c:url value='/products'/>" class="btn btn-secondary">Tiếp tục mua sắm</a>
                    <form action="<c:url value='/cart/checkout'/>" method="post">
                        <button type="submit" class="btn btn-success">Thanh toán (COD)</button>
                    </form>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <footer class="bg-light text-center py-3 border-top mt-auto">
        <div class="container">
            <p class="mb-0 text-muted">Họ tên: Đinh Thiên Bảo | MSSV: 24162009 | Mã đề: 06</p>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
