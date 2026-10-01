<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý User - 24162009 Store</title>
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
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/admin/product'/>">Quản lý Sản phẩm</a></li>
                    <li class="nav-item"><a class="nav-link active" href="<c:url value='/admin/user'/>">Quản lý User</a></li>
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
            <h3 class="mb-0">Quản lý Người Dùng</h3>
            <a href="<c:url value='/admin/user/add'/>" class="btn btn-success">Thêm User mới</a>
        </div>
        <div class="card shadow-sm">
            <div class="table-responsive">
                <table class="table table-bordered table-hover mb-0">
                    <thead class="table-light">
                        <tr>
                            <th style="width: 70px;">ID</th>
                            <th>Tên đăng nhập</th>
                            <th>Họ và tên</th>
                            <th>Email</th>
                            <th>Số điện thoại</th>
                            <th>Vai trò</th>
                            <th>Trạng thái</th>
                            <th style="width: 150px;" class="text-center">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="u" items="${list}">
                            <tr>
                                <td>${u.userId}</td>
                                <td>${u.username}</td>
                                <td>${u.fullname}</td>
                                <td>${u.email}</td>
                                <td>${u.phone}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${u.roleId == 1}"><span class="badge bg-danger">Admin</span></c:when>
                                        <c:otherwise><span class="badge bg-secondary">User</span></c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${u.status == 1}"><span class="badge bg-success">Hoạt động</span></c:when>
                                        <c:otherwise><span class="badge bg-secondary">Khóa</span></c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="text-center">
                                    <a href="<c:url value='/admin/user/edit'/>?id=${u.userId}" class="btn btn-primary btn-sm">Sửa</a>
                                    <a href="<c:url value='/admin/user/delete'/>?id=${u.userId}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc chắn muốn xóa user này?')">Xóa</a>
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
                            <a class="page-link" href="<c:url value='/admin/user'/>?page=${i}">${i}</a>
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
