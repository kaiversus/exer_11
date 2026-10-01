package com.example.midterm.dao.impl;
import com.example.midterm.dao.ICartItemDao_24162009;
import com.example.midterm.entity.CartItem_24162009;
import com.example.midterm.util.DBConnection_24162009;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartItemDaoImpl_24162009 implements ICartItemDao_24162009 {
    public void insert(CartItem_24162009 ci) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO CartItem(cartItemId, quantity, unitPrice, productId, cartId) VALUES(?,?,?,?,?)")) {
            ps.setString(1, ci.getCartItemId());
            ps.setInt(2, ci.getQuantity());
            ps.setFloat(3, ci.getUnitPrice());
            ps.setInt(4, ci.getProductId());
            ps.setString(5, ci.getCartId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void update(CartItem_24162009 ci) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE CartItem SET quantity=?, unitPrice=?, productId=?, cartId=? WHERE cartItemId=?")) {
            ps.setInt(1, ci.getQuantity());
            ps.setFloat(2, ci.getUnitPrice());
            ps.setInt(3, ci.getProductId());
            ps.setString(4, ci.getCartId());
            ps.setString(5, ci.getCartItemId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void delete(String id) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM CartItem WHERE cartItemId=?")) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public CartItem_24162009 findById(String id) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM CartItem WHERE cartItemId=?")) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CartItem_24162009 ci = new CartItem_24162009();
                ci.setCartItemId(rs.getString("cartItemId"));
                ci.setQuantity(rs.getInt("quantity"));
                ci.setUnitPrice(rs.getFloat("unitPrice"));
                ci.setProductId(rs.getInt("productId"));
                ci.setCartId(rs.getString("cartId"));
                return ci;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
    public List<CartItem_24162009> findByCartId(String cartId) {
        List<CartItem_24162009> list = new ArrayList<>();
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM CartItem WHERE cartId=?")) {
            ps.setString(1, cartId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CartItem_24162009 ci = new CartItem_24162009();
                ci.setCartItemId(rs.getString("cartItemId"));
                ci.setQuantity(rs.getInt("quantity"));
                ci.setUnitPrice(rs.getFloat("unitPrice"));
                ci.setProductId(rs.getInt("productId"));
                ci.setCartId(rs.getString("cartId"));
                list.add(ci);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    public CartItem_24162009 findByCartIdAndProductId(String cartId, int productId) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM CartItem WHERE cartId=? AND productId=?")) {
            ps.setString(1, cartId);
            ps.setInt(2, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CartItem_24162009 ci = new CartItem_24162009();
                ci.setCartItemId(rs.getString("cartItemId"));
                ci.setQuantity(rs.getInt("quantity"));
                ci.setUnitPrice(rs.getFloat("unitPrice"));
                ci.setProductId(rs.getInt("productId"));
                ci.setCartId(rs.getString("cartId"));
                return ci;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
