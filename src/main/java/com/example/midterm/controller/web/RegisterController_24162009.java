package com.example.midterm.controller.web;
import com.example.midterm.entity.Users_24162009;
import com.example.midterm.util.EmailUtil_24162009;
import java.io.IOException;
import java.util.Random;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class RegisterController_24162009 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Users_24162009 u = new Users_24162009();
        u.setUsername(req.getParameter("username"));
        u.setPassword(req.getParameter("password"));
        u.setEmail(req.getParameter("email"));
        u.setFullname(req.getParameter("fullname"));
        
        String otp = String.format("%06d", new Random().nextInt(999999));
        HttpSession session = req.getSession();
        session.setAttribute("regUser", u);
        session.setAttribute("otp", otp);
        
        EmailUtil_24162009.sendOtp(u.getEmail(), otp);
        resp.sendRedirect(req.getContextPath() + "/verify");
    }
}
