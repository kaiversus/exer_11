package com.example.midterm.service;
import com.example.midterm.entity.Cart_24162009;
import java.util.List;

public interface ICartService_24162009 {
    void insert(Cart_24162009 c);
    void update(Cart_24162009 c);
    Cart_24162009 findById(String id);
    Cart_24162009 findActiveCartByUserId(int userId);
    List<Cart_24162009> findOrdersByUserIdAndStatus(int userId, int status);
    List<Cart_24162009> findAllOrdersByUserId(int userId);
}
