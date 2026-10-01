package com.example.midterm.controller.admin;
import com.example.midterm.entity.Users_24162009;
import com.example.midterm.service.IUsersService_24162009;
import com.example.midterm.service.impl.UsersServiceImpl_24162009;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/user", "/admin/user/add", "/admin/user/edit", "/admin/user/delete"})
public class AdminUserController_24162009 extends HttpServlet {
    private IUsersService_24162009 svc = new UsersServiceImpl_24162009();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/admin/user/add")) {
            req.getRequestDispatcher("/views/admin/user-add.jsp").forward(req, resp);
        } else if (path.equals("/admin/user/edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Users_24162009 u = svc.findById(id);
            req.setAttribute("u", u);
            req.getRequestDispatcher("/views/admin/user-edit.jsp").forward(req, resp);
        } else if (path.equals("/admin/user/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            svc.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/user");
        } else {
            int page = 1;
            if (req.getParameter("page") != null) page = Integer.parseInt(req.getParameter("page"));
            int limit = 5;
            int offset = (page - 1) * limit;
            List<Users_24162009> list = svc.findAll(offset, limit);
            int total = svc.count();
            int totalPages = (int) Math.ceil((double) total / limit);
            req.setAttribute("list", list);
            req.setAttribute("currentPage", page);
            req.setAttribute("totalPages", totalPages);
            req.getRequestDispatcher("/views/admin/user-list.jsp").forward(req, resp);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String path = req.getServletPath();
        if (path.equals("/admin/user/add")) {
            Users_24162009 u = new Users_24162009();
            u.setUsername(req.getParameter("username"));
            u.setPassword(req.getParameter("password"));
            u.setFullname(req.getParameter("fullname"));
            u.setEmail(req.getParameter("email"));
            u.setPhone(req.getParameter("phone"));
            u.setRoleId(Integer.parseInt(req.getParameter("roleId")));
            u.setStatus(Integer.parseInt(req.getParameter("status")));
            svc.insert(u);
            resp.sendRedirect(req.getContextPath() + "/admin/user");
        } else if (path.equals("/admin/user/edit")) {
            int id = Integer.parseInt(req.getParameter("userId"));
            Users_24162009 u = svc.findById(id);
            if (u != null) {
                u.setFullname(req.getParameter("fullname"));
                u.setEmail(req.getParameter("email"));
                u.setPhone(req.getParameter("phone"));
                u.setRoleId(Integer.parseInt(req.getParameter("roleId")));
                u.setStatus(Integer.parseInt(req.getParameter("status")));
                String newPass = req.getParameter("password");
                if (newPass != null && !newPass.trim().isEmpty()) {
                    u.setPassword(newPass.trim());
                }
                svc.update(u);
            }
            resp.sendRedirect(req.getContextPath() + "/admin/user");
        }
    }
}
