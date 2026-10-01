package com.example.midterm.service.impl;
import com.example.midterm.dao.IUsersDao_24162009;
import com.example.midterm.dao.impl.UsersDaoImpl_24162009;
import com.example.midterm.entity.Users_24162009;
import com.example.midterm.service.IUsersService_24162009;
import java.util.List;

public class UsersServiceImpl_24162009 implements IUsersService_24162009 {
    private IUsersDao_24162009 dao = new UsersDaoImpl_24162009();
    public Users_24162009 login(String username, String password) { return dao.login(username, password); }
    public void insert(Users_24162009 u) { dao.insert(u); }
    public void update(Users_24162009 u) { dao.update(u); }
    public void delete(int id) { dao.delete(id); }
    public Users_24162009 findById(int id) { return dao.findById(id); }
    public List<Users_24162009> findAll(int offset, int limit) { return dao.findAll(offset, limit); }
    public int count() { return dao.count(); }
}
