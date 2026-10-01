package com.example.midterm.controller.web;

import com.example.midterm.entity.CartItem_24162009;
import com.example.midterm.entity.Cart_24162009;
import com.example.midterm.entity.Users_24162009;
import com.example.midterm.service.ICartItemService_24162009;
import com.example.midterm.service.ICartService_24162009;
import com.example.midterm.service.IProductService_24162009;
import com.example.midterm.service.impl.CartItemServiceImpl_24162009;
import com.example.midterm.service.impl.CartServiceImpl_24162009;
import com.example.midterm.service.impl.ProductServiceImpl_24162009;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/order-history")
public class OrderHistoryController_24162009 extends HttpServlet {
    private ICartService_24162009 cartSvc = new CartServiceImpl_24162009();
    private ICartItemService_24162009 cartItemSvc = new CartItemServiceImpl_24162009();
    private IProductService_24162009 productSvc = new ProductServiceImpl_24162009();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users_24162009 acc = (Users_24162009) req.getSession().getAttribute("account");
        if (acc == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String statusParam = req.getParameter("status");
        List<Cart_24162009> orders;
        if (statusParam != null && !statusParam.isEmpty()) {
            int status = Integer.parseInt(statusParam);
            orders = cartSvc.findOrdersByUserIdAndStatus(acc.getUserId(), status);
        } else {
            orders = cartSvc.findAllOrdersByUserId(acc.getUserId());
        }

        Map<String, List<CartItem_24162009>> orderItemsMap = new HashMap<>();
        Map<String, Double> orderTotalMap = new HashMap<>();

        for (Cart_24162009 order : orders) {
            List<CartItem_24162009> items = cartItemSvc.findByCartId(order.getCartId());
            double total = 0;
            for (CartItem_24162009 item : items) {
                item.setProduct(productSvc.findById(item.getProductId()));
                total += item.getQuantity() * item.getUnitPrice();
            }
            orderItemsMap.put(order.getCartId(), items);
            orderTotalMap.put(order.getCartId(), total);
        }

        req.setAttribute("orders", orders);
        req.setAttribute("orderItemsMap", orderItemsMap);
        req.setAttribute("orderTotalMap", orderTotalMap);
        req.getRequestDispatcher("/views/web/order-history.jsp").forward(req, resp);
    }
}
