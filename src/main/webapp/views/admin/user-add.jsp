<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm User mới - 24162009 Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex flex-column min-vh-100">
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
            </div>
        </div>
    </nav>

    <div class="container my-5 flex-grow-1">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-sm border">
                    <div class="card-header bg-white py-3">
                        <h4 class="card-title mb-0">Thêm User mới</h4>
                    </div>
                    <div class="card-body p-4">
                        <form action="<c:url value='/admin/user/add'/>" method="post">
                            <div class="mb-3">
                                <label class="form-label">Tên đăng nhập (Username)</label>
                                <input type="text" name="username" class="form-control" placeholder="Nhập username" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Mật khẩu</label>
                                <input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Họ và tên</label>
                                <input type="text" name="fullname" class="form-control" placeholder="Nhập họ và tên" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Email</label>
                                <input type="email" name="email" class="form-control" placeholder="Nhập email" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Số điện thoại</label>
                                <input type="text" name="phone" class="form-control" placeholder="Nhập số điện thoại">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Vai trò</label>
                                <select name="roleId" class="form-select">
                                    <option value="2">User (Người dùng thường)</option>
                                    <option value="1">Admin (Quản trị viên)</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Trạng thái</label>
                                <select name="status" class="form-select">
                                    <option value="1">Hoạt động</option>
                                    <option value="0">Khóa</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Lưu User</button>
                            <a href="<c:url value='/admin/user'/>" class="btn btn-secondary">Quay lại</a>
                        </form>
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
