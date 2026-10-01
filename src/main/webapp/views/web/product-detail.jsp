<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết sản phẩm - 24162009 Store</title>
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
                    <c:if test="${empty sessionScope.account}">
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/login'/>">Đăng nhập</a></li>
                    </c:if>
                    <c:if test="${not empty sessionScope.account}">
                        <li class="nav-item"><span class="nav-link text-light">Xin chào, ${sessionScope.account.fullname}</span></li>
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/cart'/>">Giỏ hàng</a></li>
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
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="<c:url value='/home'/>">Trang chủ</a></li>
                <li class="breadcrumb-item"><a href="<c:url value='/products'/>">Sản phẩm</a></li>
                <li class="breadcrumb-item active">${p.productName}</li>
            </ol>
        </nav>
        <div class="card shadow-sm">
            <div class="card-header bg-white">
                <h4 class="mb-0">${p.productName}</h4>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-4 text-center py-4 bg-light border rounded d-flex align-items-center justify-content-center">
                        <c:choose>
                            <c:when test="${not empty p.images && (p.images.startsWith('http://') || p.images.startsWith('https://'))}">
                                <img src="${p.images}" style="max-height: 250px; max-width: 100%; object-fit: contain;" alt="${p.productName}">
                            </c:when>
                            <c:when test="${not empty p.images}">
                                <img src="<c:url value='/assets/images/${p.images}'/>" style="max-height: 250px; max-width: 100%; object-fit: contain;" alt="${p.productName}" onerror="this.onerror=null;this.src='https://via.placeholder.com/200';">
                            </c:when>
                            <c:otherwise>
                                <span class="text-muted">Không có ảnh</span>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="col-md-8">
                        <table class="table table-bordered">
                            <tr>
                                <th style="width: 180px;">Mã sản phẩm</th>
                                <td>${p.productCode}</td>
                            </tr>
                            <tr>
                                <th>Danh mục ID</th>
                                <td>${p.categoryId}</td>
                            </tr>
                            <tr>
                                <th>Mã cửa hàng (Seller)</th>
                                <td>${p.sellerId}</td>
                            </tr>
                            <tr>
                                <th>Giá</th>
                                <td class="text-danger fw-bold">${p.price} VNĐ</td>
                            </tr>
                            <tr>
                                <th>Amount</th>
                                <td>${p.amount}</td>
                            </tr>
                            <tr>
                                <th>Stock (Tồn kho)</th>
                                <td>${p.stock}</td>
                            </tr>
                            <tr>
                                <th>Description (Mô tả)</th>
                                <td>${p.description}</td>
                            </tr>
                        </table>
                        <div class="d-flex gap-2">
                            <a href="<c:url value='/products'/>" class="btn btn-secondary">Quay lại danh sách</a>
                            <c:if test="${not empty sessionScope.account}">
                                <form action="<c:url value='/cart/add'/>" method="post" class="d-flex gap-2">
                                    <input type="hidden" name="productId" value="${p.productId}">
                                    <input type="number" name="quantity" value="1" min="1" max="${p.stock}" class="form-control" style="width: 80px;">
                                    <button type="submit" class="btn btn-success">Thêm vào giỏ</button>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer class="bg-light text-center py-3 border-top mt-auto">
        <div class="container">
            <p class="mb-0 text-muted">Họ tên: Đinh Thiên Bảo | MSSV: 24162009 | Mã đề: 06</p>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
