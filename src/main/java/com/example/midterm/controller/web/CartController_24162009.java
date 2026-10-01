package com.example.midterm.controller.web;

import com.example.midterm.entity.CartItem_24162009;
import com.example.midterm.entity.Cart_24162009;
import com.example.midterm.entity.Product_24162009;
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
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = {"/cart", "/cart/add", "/cart/update", "/cart/remove", "/cart/checkout"})
public class CartController_24162009 extends HttpServlet {
    private ICartService_24162009 cartSvc = new CartServiceImpl_24162009();
    private ICartItemService_24162009 cartItemSvc = new CartItemServiceImpl_24162009();
    private IProductService_24162009 productSvc = new ProductServiceImpl_24162009();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if ("/cart".equals(path)) {
            Users_24162009 acc = (Users_24162009) req.getSession().getAttribute("account");
            if (acc == null) {
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            }
            Cart_24162009 cart = cartSvc.findActiveCartByUserId(acc.getUserId());
            if (cart != null) {
                List<CartItem_24162009> items = cartItemSvc.findByCartId(cart.getCartId());
                double total = 0;
                for (CartItem_24162009 item : items) {
                    item.setProduct(productSvc.findById(item.getProductId()));
                    total += item.getQuantity() * item.getUnitPrice();
                }
                req.setAttribute("cartItems", items);
                req.setAttribute("cart", cart);
                req.setAttribute("totalPrice", total);
            }
            req.getRequestDispatcher("/views/web/cart.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        Users_24162009 acc = (Users_24162009) req.getSession().getAttribute("account");
        if (acc == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        if ("/cart/add".equals(path)) {
            int productId = Integer.parseInt(req.getParameter("productId"));
            int qty = Integer.parseInt(req.getParameter("quantity"));
            Product_24162009 product = productSvc.findById(productId);
            
            Cart_24162009 cart = cartSvc.findActiveCartByUserId(acc.getUserId());
            if (cart == null) {
                cart = new Cart_24162009();
                cart.setCartId(UUID.randomUUID().toString());
                cart.setUserId(acc.getUserId());
                cart.setBuyDate(new Date(System.currentTimeMillis()));
                cart.setStatus(0);
                cartSvc.insert(cart);
            }

            CartItem_24162009 item = cartItemSvc.findByCartIdAndProductId(cart.getCartId(), productId);
            if (item == null) {
                if (qty > product.getStock()) qty = product.getStock();
                item = new CartItem_24162009();
                item.setCartItemId(UUID.randomUUID().toString());
                item.setCartId(cart.getCartId());
                item.setProductId(productId);
                item.setQuantity(qty);
                item.setUnitPrice(product.getPrice());
                cartItemSvc.insert(item);
            } else {
                int newQty = item.getQuantity() + qty;
                if (newQty > product.getStock()) newQty = product.getStock();
                item.setQuantity(newQty);
                cartItemSvc.update(item);
            }
            resp.sendRedirect(req.getContextPath() + "/cart");
        } else if ("/cart/update".equals(path)) {
            String cartItemId = req.getParameter("cartItemId");
            int qty = Integer.parseInt(req.getParameter("quantity"));
            CartItem_24162009 item = cartItemSvc.findById(cartItemId);
            if (item != null) {
                Product_24162009 product = productSvc.findById(item.getProductId());
                if (qty > product.getStock()) qty = product.getStock();
                if (qty < 1) qty = 1;
                item.setQuantity(qty);
                cartItemSvc.update(item);
            }
            resp.sendRedirect(req.getContextPath() + "/cart");
        } else if ("/cart/remove".equals(path)) {
            String cartItemId = req.getParameter("cartItemId");
            cartItemSvc.delete(cartItemId);
            resp.sendRedirect(req.getContextPath() + "/cart");
        } else if ("/cart/checkout".equals(path)) {
            Cart_24162009 cart = cartSvc.findActiveCartByUserId(acc.getUserId());
            if (cart != null) {
                cart.setStatus(1);
                cart.setBuyDate(new Date(System.currentTimeMillis()));
                cartSvc.update(cart);
            }
            resp.sendRedirect(req.getContextPath() + "/order-history");
        }
    }
}
