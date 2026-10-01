package com.example.midterm.dao.impl;
import com.example.midterm.dao.ICategoryDao_24162009;
import com.example.midterm.entity.Category_24162009;
import com.example.midterm.util.DBConnection_24162009;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl_24162009 implements ICategoryDao_24162009 {
    public void insert(Category_24162009 c) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO Category(categoryName, status) VALUES(?,?)")) {
            ps.setString(1, c.getCategoryName());
            ps.setInt(2, c.getStatus());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void update(Category_24162009 c) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE Category SET categoryName=?, status=? WHERE categoryId=?")) {
            ps.setString(1, c.getCategoryName());
            ps.setInt(2, c.getStatus());
            ps.setInt(3, c.getCategoryId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void delete(int id) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM Category WHERE categoryId=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public Category_24162009 findById(int id) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Category WHERE categoryId=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category_24162009 c = new Category_24162009();
                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));
                return c;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
    public List<Category_24162009> findAll(int offset, int limit) {
        List<Category_24162009> list = new ArrayList<>();
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Category ORDER BY categoryId LIMIT ? OFFSET ?")) {
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category_24162009 c = new Category_24162009();
                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));
                list.add(c);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    public int count() {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM Category");
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }
}
