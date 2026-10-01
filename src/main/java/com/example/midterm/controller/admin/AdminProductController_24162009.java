package com.example.midterm.controller.admin;

import com.example.midterm.entity.Category_24162009;
import com.example.midterm.entity.Product_24162009;
import com.example.midterm.service.ICategoryService_24162009;
import com.example.midterm.service.IProductService_24162009;
import com.example.midterm.service.impl.CategoryServiceImpl_24162009;
import com.example.midterm.service.impl.ProductServiceImpl_24162009;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 20)
@WebServlet(urlPatterns = {"/admin/product", "/admin/product/add", "/admin/product/edit", "/admin/product/delete"})
public class AdminProductController_24162009 extends HttpServlet {
    private IProductService_24162009 productSvc = new ProductServiceImpl_24162009();
    private ICategoryService_24162009 categorySvc = new CategoryServiceImpl_24162009();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/admin/product/add")) {
            List<Category_24162009> categories = categorySvc.findAll(0, 100);
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/views/admin/product-add.jsp").forward(req, resp);
        } else if (path.equals("/admin/product/edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Product_24162009 p = productSvc.findById(id);
            List<Category_24162009> categories = categorySvc.findAll(0, 100);
            req.setAttribute("p", p);
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/views/admin/product-edit.jsp").forward(req, resp);
        } else if (path.equals("/admin/product/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            productSvc.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/product");
        } else {
            int page = 1;
            if (req.getParameter("page") != null) page = Integer.parseInt(req.getParameter("page"));
            int limit = 5;
            int offset = (page - 1) * limit;
            List<Product_24162009> list = productSvc.findAll(offset, limit);
            int total = productSvc.count();
            int totalPages = (int) Math.ceil((double) total / limit);
            req.setAttribute("list", list);
            req.setAttribute("currentPage", page);
            req.setAttribute("totalPages", totalPages);
            req.getRequestDispatcher("/views/admin/product-list.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String path = req.getServletPath();
        
        String productName = req.getParameter("productName");
        long productCode = Long.parseLong(req.getParameter("productCode"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String description = req.getParameter("description");
        float price = Float.parseFloat(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        int sellerId = Integer.parseInt(req.getParameter("sellerId"));
        int status = Integer.parseInt(req.getParameter("status"));

        String image = req.getParameter("images");
        Part part = null;
        try {
            part = req.getPart("imageFile");
        } catch (Exception ex) {}

        if (part != null && part.getSize() > 0) {
            String submittedFileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            String uploadDir = req.getServletContext().getRealPath("/assets/images");
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();
            String uniqueName = System.currentTimeMillis() + "_" + submittedFileName;
            part.write(uploadDir + File.separator + uniqueName);
            image = uniqueName;
        }

        if (path.equals("/admin/product/add")) {
            Product_24162009 p = new Product_24162009();
            p.setProductName(productName);
            p.setProductCode(productCode);
            p.setCategoryId(categoryId);
            p.setDescription(description);
            p.setPrice(price);
            p.setAmount(amount);
            p.setStock(stock);
            p.setSellerId(sellerId);
            p.setStatus(status);
            p.setImages(image);
            productSvc.insert(p);
        } else if (path.equals("/admin/product/edit")) {
            int productId = Integer.parseInt(req.getParameter("productId"));
            Product_24162009 p = productSvc.findById(productId);
            if (p != null) {
                p.setProductName(productName);
                p.setProductCode(productCode);
                p.setCategoryId(categoryId);
                p.setDescription(description);
                p.setPrice(price);
                p.setAmount(amount);
                p.setStock(stock);
                p.setSellerId(sellerId);
                p.setStatus(status);
                if (image != null && !image.trim().isEmpty()) {
                    p.setImages(image);
                }
                productSvc.update(p);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/admin/product");
    }
}
