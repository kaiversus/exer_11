package com.example.midterm.dao.impl;
import com.example.midterm.dao.IProductDao_24162009;
import com.example.midterm.entity.Product_24162009;
import com.example.midterm.util.DBConnection_24162009;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl_24162009 implements IProductDao_24162009 {
    public List<Product_24162009> findAll() {
        List<Product_24162009> list = new ArrayList<>();
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Product ORDER BY sellerId");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Product_24162009 p = new Product_24162009();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("productName"));
                p.setProductCode(rs.getLong("productCode"));
                p.setCategoryId(rs.getInt("categoryId"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getFloat("price"));
                p.setAmount(rs.getInt("amount"));
                p.setStock(rs.getInt("stock"));
                p.setImages(rs.getString("images"));
                p.setSellerId(rs.getInt("sellerId"));
                p.setStatus(rs.getInt("status"));
                list.add(p);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    public List<Product_24162009> findAll(int offset, int limit) {
        List<Product_24162009> list = new ArrayList<>();
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Product ORDER BY productId LIMIT ? OFFSET ?")) {
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product_24162009 p = new Product_24162009();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("productName"));
                p.setProductCode(rs.getLong("productCode"));
                p.setCategoryId(rs.getInt("categoryId"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getFloat("price"));
                p.setAmount(rs.getInt("amount"));
                p.setStock(rs.getInt("stock"));
                p.setImages(rs.getString("images"));
                p.setSellerId(rs.getInt("sellerId"));
                p.setStatus(rs.getInt("status"));
                list.add(p);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    public Product_24162009 findById(int id) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Product WHERE productId=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Product_24162009 p = new Product_24162009();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("productName"));
                p.setProductCode(rs.getLong("productCode"));
                p.setCategoryId(rs.getInt("categoryId"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getFloat("price"));
                p.setAmount(rs.getInt("amount"));
                p.setStock(rs.getInt("stock"));
                p.setImages(rs.getString("images"));
                p.setSellerId(rs.getInt("sellerId"));
                p.setStatus(rs.getInt("status"));
                return p;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
    public void insert(Product_24162009 p) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO Product(productName, productCode, categoryId, description, price, amount, stock, images, status, sellerId, createDate) VALUES(?,?,?,?,?,?,?,?,?,?,CURDATE())")) {
            ps.setString(1, p.getProductName());
            ps.setLong(2, p.getProductCode());
            ps.setInt(3, p.getCategoryId());
            ps.setString(4, p.getDescription());
            ps.setFloat(5, p.getPrice());
            ps.setInt(6, p.getAmount());
            ps.setInt(7, p.getStock());
            ps.setString(8, p.getImages());
            ps.setInt(9, p.getStatus() != 0 ? p.getStatus() : 1);
            ps.setInt(10, p.getSellerId() != 0 ? p.getSellerId() : 1);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void update(Product_24162009 p) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE Product SET productName=?, productCode=?, categoryId=?, description=?, price=?, amount=?, stock=?, images=?, status=?, sellerId=? WHERE productId=?")) {
            ps.setString(1, p.getProductName());
            ps.setLong(2, p.getProductCode());
            ps.setInt(3, p.getCategoryId());
            ps.setString(4, p.getDescription());
            ps.setFloat(5, p.getPrice());
            ps.setInt(6, p.getAmount());
            ps.setInt(7, p.getStock());
            ps.setString(8, p.getImages());
            ps.setInt(9, p.getStatus());
            ps.setInt(10, p.getSellerId());
            ps.setInt(11, p.getProductId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void delete(int id) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM Product WHERE productId=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public int count() {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM Product");
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }
}
