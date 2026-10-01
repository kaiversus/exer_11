package com.example.midterm.dao.impl;
import com.example.midterm.dao.ICartDao_24162009;
import com.example.midterm.entity.Cart_24162009;
import com.example.midterm.util.DBConnection_24162009;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl_24162009 implements ICartDao_24162009 {
    public void insert(Cart_24162009 c) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO Cart(cartId, userId, buyDate, status) VALUES(?,?,?,?)")) {
            ps.setString(1, c.getCartId());
            ps.setInt(2, c.getUserId());
            ps.setDate(3, c.getBuyDate());
            ps.setInt(4, c.getStatus());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void update(Cart_24162009 c) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE Cart SET userId=?, buyDate=?, status=? WHERE cartId=?")) {
            ps.setInt(1, c.getUserId());
            ps.setDate(2, c.getBuyDate());
            ps.setInt(3, c.getStatus());
            ps.setString(4, c.getCartId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public Cart_24162009 findById(String id) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Cart WHERE cartId=?")) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cart_24162009 c = new Cart_24162009();
                c.setCartId(rs.getString("cartId"));
                c.setUserId(rs.getInt("userId"));
                c.setBuyDate(rs.getDate("buyDate"));
                c.setStatus(rs.getInt("status"));
                return c;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
    public Cart_24162009 findActiveCartByUserId(int userId) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Cart WHERE userId=? AND status=0 LIMIT 1")) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cart_24162009 c = new Cart_24162009();
                c.setCartId(rs.getString("cartId"));
                c.setUserId(rs.getInt("userId"));
                c.setBuyDate(rs.getDate("buyDate"));
                c.setStatus(rs.getInt("status"));
                return c;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
    public List<Cart_24162009> findOrdersByUserIdAndStatus(int userId, int status) {
        List<Cart_24162009> list = new ArrayList<>();
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Cart WHERE userId=? AND status=? ORDER BY buyDate DESC")) {
            ps.setInt(1, userId);
            ps.setInt(2, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cart_24162009 c = new Cart_24162009();
                c.setCartId(rs.getString("cartId"));
                c.setUserId(rs.getInt("userId"));
                c.setBuyDate(rs.getDate("buyDate"));
                c.setStatus(rs.getInt("status"));
                list.add(c);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    public List<Cart_24162009> findAllOrdersByUserId(int userId) {
        List<Cart_24162009> list = new ArrayList<>();
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Cart WHERE userId=? AND status>0 ORDER BY buyDate DESC")) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cart_24162009 c = new Cart_24162009();
                c.setCartId(rs.getString("cartId"));
                c.setUserId(rs.getInt("userId"));
                c.setBuyDate(rs.getDate("buyDate"));
                c.setStatus(rs.getInt("status"));
                list.add(c);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
