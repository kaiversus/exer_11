package com.example.midterm.service;
import com.example.midterm.entity.CartItem_24162009;
import java.util.List;

public interface ICartItemService_24162009 {
    void insert(CartItem_24162009 ci);
    void update(CartItem_24162009 ci);
    void delete(String id);
    CartItem_24162009 findById(String id);
    List<CartItem_24162009> findByCartId(String cartId);
    CartItem_24162009 findByCartIdAndProductId(String cartId, int productId);
}
