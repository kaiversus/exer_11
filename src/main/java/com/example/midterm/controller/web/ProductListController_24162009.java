package com.example.midterm.controller.web;
import com.example.midterm.entity.Product_24162009;
import com.example.midterm.service.IProductService_24162009;
import com.example.midterm.service.impl.ProductServiceImpl_24162009;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductListController_24162009 extends HttpServlet {
    private IProductService_24162009 svc = new ProductServiceImpl_24162009();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product_24162009> list = svc.findAll();
        req.setAttribute("products", list);
        req.getRequestDispatcher("/views/web/products.jsp").forward(req, resp);
    }
}
