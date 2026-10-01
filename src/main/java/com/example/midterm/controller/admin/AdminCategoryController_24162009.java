package com.example.midterm.controller.admin;
import com.example.midterm.entity.Category_24162009;
import com.example.midterm.service.ICategoryService_24162009;
import com.example.midterm.service.impl.CategoryServiceImpl_24162009;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/category", "/admin/category/add", "/admin/category/edit", "/admin/category/delete"})
public class AdminCategoryController_24162009 extends HttpServlet {
    private ICategoryService_24162009 svc = new CategoryServiceImpl_24162009();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/admin/category/add")) {
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        } else if (path.equals("/admin/category/edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Category_24162009 c = svc.findById(id);
            req.setAttribute("c", c);
            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        } else if (path.equals("/admin/category/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            svc.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/category");
        } else {
            int page = 1;
            if (req.getParameter("page") != null) page = Integer.parseInt(req.getParameter("page"));
            int limit = 5;
            int offset = (page - 1) * limit;
            List<Category_24162009> list = svc.findAll(offset, limit);
            int total = svc.count();
            int totalPages = (int) Math.ceil((double) total / limit);
            req.setAttribute("list", list);
            req.setAttribute("currentPage", page);
            req.setAttribute("totalPages", totalPages);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String path = req.getServletPath();
        Category_24162009 c = new Category_24162009();
        c.setCategoryName(req.getParameter("categoryName"));
        c.setStatus(Integer.parseInt(req.getParameter("status")));
        if (path.equals("/admin/category/add")) {
            svc.insert(c);
        } else if (path.equals("/admin/category/edit")) {
            c.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));
            svc.update(c);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/category");
    }
}
