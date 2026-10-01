<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm sản phẩm mới - 24162009 Store</title>
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
                    <li class="nav-item"><a class="nav-link active" href="<c:url value='/admin/product'/>">Quản lý Sản phẩm</a></li>
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/admin/user'/>">Quản lý User</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container my-4 flex-grow-1">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card shadow-sm border">
                    <div class="card-header bg-white py-3">
                        <h4 class="card-title mb-0">Thêm sản phẩm mới</h4>
                    </div>
                    <div class="card-body p-4">
                        <form action="<c:url value='/admin/product/add'/>" method="post" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Tên sản phẩm</label>
                                    <input type="text" name="productName" class="form-control" placeholder="Nhập tên sản phẩm" required>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Mã sản phẩm (Code)</label>
                                    <input type="number" name="productCode" class="form-control" placeholder="Ví dụ: 101" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Danh mục (Category)</label>
                                    <select name="categoryId" class="form-select" required>
                                        <c:forEach var="cat" items="${categories}">
                                            <option value="${cat.categoryId}">${cat.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Mã cửa hàng (Seller ID)</label>
                                    <input type="number" name="sellerId" class="form-control" value="1" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 mb-3">
                                    <label class="form-label">Giá bán (VNĐ)</label>
                                    <input type="number" step="0.01" name="price" class="form-control" placeholder="Giá" required>
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label class="form-label">Số lượng (Amount)</label>
                                    <input type="number" name="amount" class="form-control" value="10" required>
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label class="form-label">Tồn kho (Stock)</label>
                                    <input type="number" name="stock" class="form-control" value="10" required>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Tải file ảnh lên</label>
                                <input type="file" name="imageFile" class="form-control" accept="image/png, image/jpeg, image/gif, image/webp">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Hoặc nhập URL / tên file ảnh</label>
                                <input type="text" name="images" class="form-control" placeholder="https://... hoặc ten-anh.jpg">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Mô tả sản phẩm</label>
                                <textarea name="description" class="form-control" rows="3" placeholder="Nhập mô tả chi tiết sản phẩm"></textarea>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Trạng thái</label>
                                <select name="status" class="form-select">
                                    <option value="1">Đang bán (Active)</option>
                                    <option value="0">Ngừng bán (Inactive)</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Lưu sản phẩm</button>
                            <a href="<c:url value='/admin/product'/>" class="btn btn-secondary">Quay lại</a>
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
