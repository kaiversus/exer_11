<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Sản phẩm - 24162009 Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="<c:url value='/admin/home'/>">Admin - 24162009 Store</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/admin/home'/>">Dashboard</a></li>
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/admin/category'/>">Quản lý Category</a></li>
                    <li class="nav-item"><a class="nav-link active" href="<c:url value='/admin/product'/>">Quản lý Sản phẩm</a></li>
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/admin/user'/>">Quản lý User</a></li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/home'/>">Về trang chủ</a></li>
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/logout'/>">Đăng xuất</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container my-4 flex-grow-1">
        <div class="d-flex justify-content-between align-items-center mb-3 pb-2 border-bottom">
            <h3 class="mb-0">Quản lý Sản phẩm</h3>
            <a href="<c:url value='/admin/product/add'/>" class="btn btn-success">Thêm sản phẩm mới</a>
        </div>
        <div class="card shadow-sm">
            <div class="table-responsive">
                <table class="table table-bordered table-hover mb-0 align-middle">
                    <thead class="table-light">
                        <tr>
                            <th style="width: 70px;">ID</th>
                            <th style="width: 90px;" class="text-center">Hình ảnh</th>
                            <th>Tên sản phẩm</th>
                            <th>Mã SP</th>
                            <th>Danh mục ID</th>
                            <th>Seller ID</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Tồn kho</th>
                            <th style="width: 150px;" class="text-center">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${list}">
                            <tr>
                                <td>${p.productId}</td>
                                <td class="text-center p-1">
                                    <c:choose>
                                        <c:when test="${not empty p.images && (p.images.startsWith('http://') || p.images.startsWith('https://'))}">
                                            <img src="${p.images}" style="height: 50px; width: 50px; object-fit: cover;" class="border rounded" alt="${p.productName}">
                                        </c:when>
                                        <c:when test="${not empty p.images}">
                                            <img src="<c:url value='/assets/images/${p.images}'/>" style="height: 50px; width: 50px; object-fit: cover;" class="border rounded" alt="${p.productName}" onerror="this.onerror=null;this.src='https://via.placeholder.com/50';">
                                        </c:when>
                                        <c:otherwise>
                                            <span class="text-muted small">No image</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${p.productName}</td>
                                <td>${p.productCode}</td>
                                <td>${p.categoryId}</td>
                                <td>${p.sellerId}</td>
                                <td class="text-danger fw-bold">${p.price}</td>
                                <td>${p.amount}</td>
                                <td>${p.stock}</td>
                                <td class="text-center">
                                    <a href="<c:url value='/admin/product/edit'/>?id=${p.productId}" class="btn btn-primary btn-sm">Sửa</a>
                                    <a href="<c:url value='/admin/product/delete'/>?id=${p.productId}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?')">Xóa</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <c:if test="${totalPages > 1}">
            <nav class="mt-3">
                <ul class="pagination justify-content-center">
                    <c:forEach begin="1" end="${totalPages}" var="i">
                        <li class="page-item ${i == currentPage ? 'active' : ''}">
                            <a class="page-link" href="<c:url value='/admin/product'/>?page=${i}">${i}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </c:if>
    </div>

    <footer class="bg-light text-center py-3 border-top mt-auto">
        <div class="container">
            <p class="mb-0 text-muted">Họ tên: Đinh Thiên Bảo | MSSV: 24162009 | Mã đề: 06</p>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
