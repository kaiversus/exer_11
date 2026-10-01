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

@WebServlet("/login")
public class LoginController_24162009 extends HttpServlet {
    private IUsersService_24162009 svc = new UsersServiceImpl_24162009();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        Users_24162009 acc = svc.login(u, p);
        if (acc != null) {
            HttpSession session = req.getSession();
            session.setAttribute("account", acc);
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
        }
    }
}
