package com.example.midterm.service.impl;
import com.example.midterm.dao.ICartItemDao_24162009;
import com.example.midterm.dao.impl.CartItemDaoImpl_24162009;
import com.example.midterm.entity.CartItem_24162009;
import com.example.midterm.service.ICartItemService_24162009;
import java.util.List;

public class CartItemServiceImpl_24162009 implements ICartItemService_24162009 {
    ICartItemDao_24162009 cartItemDao = new CartItemDaoImpl_24162009();
    public void insert(CartItem_24162009 ci) { cartItemDao.insert(ci); }
    public void update(CartItem_24162009 ci) { cartItemDao.update(ci); }
    public void delete(String id) { cartItemDao.delete(id); }
    public CartItem_24162009 findById(String id) { return cartItemDao.findById(id); }
    public List<CartItem_24162009> findByCartId(String cartId) { return cartItemDao.findByCartId(cartId); }
    public CartItem_24162009 findByCartIdAndProductId(String cartId, int productId) { return cartItemDao.findByCartIdAndProductId(cartId, productId); }
}
