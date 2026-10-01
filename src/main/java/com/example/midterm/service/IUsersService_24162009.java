package com.example.midterm.service;
import com.example.midterm.entity.Users_24162009;
import java.util.List;
public interface IUsersService_24162009 {
    Users_24162009 login(String username, String password);
    void insert(Users_24162009 u);
    void update(Users_24162009 u);
    void delete(int id);
    Users_24162009 findById(int id);
    List<Users_24162009> findAll(int offset, int limit);
    int count();
}