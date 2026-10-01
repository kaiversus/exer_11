package com.example.midterm.controller.web;
import com.example.midterm.entity.Users_24162009;
import com.example.midterm.service.IUsersService_24162009;
import com.example.midterm.service.impl.UsersServiceImpl_24162009;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/verify")
public class VerifyController_24162009 extends HttpServlet {
    private IUsersService_24162009 svc = new UsersServiceImpl_24162009();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/web/verify.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionOtp = (String) session.getAttribute("otp");
        String reqOtp = req.getParameter("otp");
        if (sessionOtp != null && sessionOtp.equals(reqOtp)) {
            Users_24162009 u = (Users_24162009) session.getAttribute("regUser");
            svc.insert(u);
            session.removeAttribute("otp");
            session.removeAttribute("regUser");
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            req.setAttribute("error", "Invalid OTP");
            req.getRequestDispatcher("/views/web/verify.jsp").forward(req, resp);
        }
    }
}
