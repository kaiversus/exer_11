package com.example.midterm.service.impl;
import com.example.midterm.dao.ICartDao_24162009;
import com.example.midterm.dao.impl.CartDaoImpl_24162009;
import com.example.midterm.entity.Cart_24162009;
import com.example.midterm.service.ICartService_24162009;
import java.util.List;

public class CartServiceImpl_24162009 implements ICartService_24162009 {
    ICartDao_24162009 cartDao = new CartDaoImpl_24162009();
    public void insert(Cart_24162009 c) { cartDao.insert(c); }
    public void update(Cart_24162009 c) { cartDao.update(c); }
    public Cart_24162009 findById(String id) { return cartDao.findById(id); }
    public Cart_24162009 findActiveCartByUserId(int userId) { return cartDao.findActiveCartByUserId(userId); }
    public List<Cart_24162009> findOrdersByUserIdAndStatus(int userId, int status) { return cartDao.findOrdersByUserIdAndStatus(userId, status); }
    public List<Cart_24162009> findAllOrdersByUserId(int userId) { return cartDao.findAllOrdersByUserId(userId); }
}
