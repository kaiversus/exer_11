package com.example.midterm.controller.web;
import com.example.midterm.entity.Product_24162009;
import com.example.midterm.service.IProductService_24162009;
import com.example.midterm.service.impl.ProductServiceImpl_24162009;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product/detail")
public class ProductDetailController_24162009 extends HttpServlet {
    private IProductService_24162009 svc = new ProductServiceImpl_24162009();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product_24162009 p = svc.findById(id);
        req.setAttribute("p", p);
        req.getRequestDispatcher("/views/web/product-detail.jsp").forward(req, resp);
    }
}
