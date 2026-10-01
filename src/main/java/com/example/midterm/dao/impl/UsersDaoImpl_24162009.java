package com.example.midterm.dao.impl;
import com.example.midterm.dao.IUsersDao_24162009;
import com.example.midterm.entity.Users_24162009;
import com.example.midterm.util.DBConnection_24162009;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl_24162009 implements IUsersDao_24162009 {
    public Users_24162009 login(String username, String password) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE username=? AND password=?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Users_24162009 u = new Users_24162009();
                u.setUserId(rs.getInt("userId"));
                u.setUsername(rs.getString("username"));
                u.setFullname(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                u.setRoleId(rs.getInt("roleId"));
                u.setSellerId(rs.getInt("sellerId"));
                u.setStatus(rs.getInt("status"));
                u.setPhone(rs.getString("phone"));
                return u;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
    public void insert(Users_24162009 u) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO Users(username, email, fullname, password, status, roleId, phone) VALUES(?,?,?,?,?,?,?)")) {
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getFullname());
            ps.setString(4, u.getPassword());
            ps.setInt(5, u.getStatus() != 0 ? u.getStatus() : 1);
            ps.setInt(6, u.getRoleId() != 0 ? u.getRoleId() : 2);
            ps.setString(7, u.getPhone());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void update(Users_24162009 u) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE Users SET fullname=?, email=?, phone=?, roleId=?, status=? WHERE userId=?")) {
            ps.setString(1, u.getFullname());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPhone());
            ps.setInt(4, u.getRoleId());
            ps.setInt(5, u.getStatus());
            ps.setInt(6, u.getUserId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void delete(int id) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM Users WHERE userId=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public Users_24162009 findById(int id) {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE userId=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Users_24162009 u = new Users_24162009();
                u.setUserId(rs.getInt("userId"));
                u.setUsername(rs.getString("username"));
                u.setFullname(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                u.setRoleId(rs.getInt("roleId"));
                u.setSellerId(rs.getInt("sellerId"));
                u.setStatus(rs.getInt("status"));
                u.setPhone(rs.getString("phone"));
                return u;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
    public List<Users_24162009> findAll(int offset, int limit) {
        List<Users_24162009> list = new ArrayList<>();
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Users ORDER BY userId LIMIT ? OFFSET ?")) {
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users_24162009 u = new Users_24162009();
                u.setUserId(rs.getInt("userId"));
                u.setUsername(rs.getString("username"));
                u.setFullname(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                u.setRoleId(rs.getInt("roleId"));
                u.setStatus(rs.getInt("status"));
                u.setPhone(rs.getString("phone"));
                list.add(u);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    public int count() {
        try (Connection con = DBConnection_24162009.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM Users");
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }
}
