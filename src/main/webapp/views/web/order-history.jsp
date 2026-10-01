<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lịch sử đơn hàng - 24162009 Store</title>
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
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/cart'/>">Giỏ hàng</a></li>
                        <li class="nav-item"><a class="nav-link active" href="<c:url value='/order-history'/>">Lịch sử đơn hàng</a></li>
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
        <h3 class="mb-4">Lịch sử đơn hàng</h3>
        
        <form method="get" action="<c:url value='/order-history'/>" class="mb-4 d-flex gap-2">
            <select name="status" class="form-select" style="width: auto;">
                <option value="">Tất cả</option>
                <option value="1" ${param.status == '1' ? 'selected' : ''}>Đơn hàng mới</option>
                <option value="2" ${param.status == '2' ? 'selected' : ''}>Đã xác nhận</option>
                <option value="3" ${param.status == '3' ? 'selected' : ''}>Chuẩn bị hàng</option>
                <option value="4" ${param.status == '4' ? 'selected' : ''}>Vận chuyển</option>
                <option value="5" ${param.status == '5' ? 'selected' : ''}>Giao hàng</option>
                <option value="6" ${param.status == '6' ? 'selected' : ''}>Đã giao</option>
                <option value="7" ${param.status == '7' ? 'selected' : ''}>Đơn hàng hủy</option>
                <option value="8" ${param.status == '8' ? 'selected' : ''}>Đơn hàng hoàn</option>
            </select>
            <button type="submit" class="btn btn-primary">Lọc</button>
        </form>

        <c:choose>
            <c:when test="${empty orders}">
                <div class="alert alert-info">Chưa có đơn hàng nào.</div>
            </c:when>
            <c:otherwise>
                <c:forEach var="order" items="${orders}">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header bg-light d-flex justify-content-between">
                            <span><strong>Mã ĐH:</strong> ${order.cartId}</span>
                            <span><strong>Ngày đặt:</strong> ${order.buyDate}</span>
                            <span class="badge bg-info text-dark">
                                <c:choose>
                                    <c:when test="${order.status == 1}">Đơn hàng mới</c:when>
                                    <c:when test="${order.status == 2}">Đã xác nhận</c:when>
                                    <c:when test="${order.status == 3}">Chuẩn bị hàng</c:when>
                                    <c:when test="${order.status == 4}">Vận chuyển</c:when>
                                    <c:when test="${order.status == 5}">Giao hàng</c:when>
                                    <c:when test="${order.status == 6}">Đã giao</c:when>
                                    <c:when test="${order.status == 7}">Đơn hàng hủy</c:when>
                                    <c:when test="${order.status == 8}">Đơn hàng hoàn</c:when>
                                </c:choose>
                            </span>
                        </div>
                        <div class="card-body">
                            <table class="table table-sm table-borderless">
                                <thead>
                                    <tr>
                                        <th>Sản phẩm</th>
                                        <th>SL</th>
                                        <th>Giá</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${orderItemsMap[order.cartId]}">
                                        <tr>
                                            <td>${item.product.productName}</td>
                                            <td>${item.quantity}</td>
                                            <td>${item.unitPrice}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="card-footer text-end">
                            <strong>Tổng tiền:</strong> <span class="text-danger">${orderTotalMap[order.cartId]} VNĐ</span>
                        </div>
                    </div>
                </c:forEach>
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
