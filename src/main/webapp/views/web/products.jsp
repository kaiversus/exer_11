<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách sản phẩm - 24162009 Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="<c:url value='/home'/>">24162009 Store</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/home'/>">Trang Chủ</a></li>
                    <li class="nav-item"><a class="nav-link active" href="<c:url value='/products'/>">Sản phẩm</a></li>
                </ul>
                <ul class="navbar-nav">
                    <c:if test="${empty sessionScope.account}">
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/login'/>">Đăng nhập</a></li>
                        <li class="nav-item"><a class="nav-link" href="<c:url value='/register'/>">Đăng ký</a></li>
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
        <h3 class="mb-4 pb-2 border-bottom">Danh sách sản phẩm theo Seller</h3>
        <c:if test="${empty products}">
            <div class="alert alert-info">Hiện chưa có sản phẩm nào trong hệ thống.</div>
        </c:if>
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <c:forEach var="p" items="${products}">
                <div class="col">
                    <div class="card h-100 shadow-sm">
                        <div class="bg-light text-center p-3 border-bottom" style="height: 180px; display: flex; align-items: center; justify-content: center;">
                            <c:choose>
                                <c:when test="${not empty p.images && (p.images.startsWith('http://') || p.images.startsWith('https://'))}">
                                    <img src="${p.images}" style="max-height: 160px; max-width: 100%; object-fit: contain;" alt="${p.productName}">
                                </c:when>
                                <c:when test="${not empty p.images}">
                                    <img src="<c:url value='/assets/images/${p.images}'/>" style="max-height: 160px; max-width: 100%; object-fit: contain;" alt="${p.productName}" onerror="this.onerror=null;this.src='https://via.placeholder.com/150';">
                                </c:when>
                                <c:otherwise>
                                    <span class="text-muted">Không có ảnh</span>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="card-body">
                            <span class="badge bg-secondary mb-2">Mã cửa hàng: ${p.sellerId}</span>
                            <h5 class="card-title">
                                <a href="<c:url value='/product/detail'/>?id=${p.productId}" class="text-decoration-none text-dark">${p.productName}</a>
                            </h5>
                            <p class="card-text text-muted mb-1">Mã sản phẩm: ${p.productCode}</p>
                            <p class="card-text text-muted mb-1">Danh mục ID: ${p.categoryId}</p>
                            <p class="card-text text-muted mb-2">Amount: ${p.amount}</p>
                            <h5 class="text-danger mb-0">Giá: ${p.price} VNĐ</h5>
                        </div>
                        <div class="card-footer bg-white border-top-0 pt-0">
                            <a href="<c:url value='/product/detail'/>?id=${p.productId}" class="btn btn-outline-primary btn-sm w-100 mb-2">Xem chi tiết</a>
                            <c:if test="${not empty sessionScope.account}">
                                <form action="<c:url value='/cart/add'/>" method="post">
                                    <input type="hidden" name="productId" value="${p.productId}">
                                    <input type="hidden" name="quantity" value="1">
                                    <button type="submit" class="btn btn-success btn-sm w-100">Thêm vào giỏ</button>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
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
