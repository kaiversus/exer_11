<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xác nhận OTP - 24162009 Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex flex-column min-vh-100">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="<c:url value='/home'/>">24162009 Store</a>
        </div>
    </nav>

    <div class="container my-5 flex-grow-1">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card shadow-sm border">
                    <div class="card-header bg-white py-3 text-center">
                        <h4 class="card-title mb-0">Xác thực mã OTP</h4>
                    </div>
                    <div class="card-body p-4 text-center">
                        <p class="text-muted">Mã OTP đã được gửi đến email đăng ký của bạn. Vui lòng kiểm tra hộp thư.</p>
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger py-2">${error}</div>
                        </c:if>
                        <form action="verify" method="post">
                            <div class="mb-3">
                                <input type="text" name="otp" class="form-control form-control-lg text-center" placeholder="Nhập mã 6 số" maxlength="6" required>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Xác nhận</button>
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
