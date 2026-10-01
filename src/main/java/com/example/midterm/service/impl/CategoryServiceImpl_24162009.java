package com.example.midterm.service.impl;
import com.example.midterm.dao.ICategoryDao_24162009;
import com.example.midterm.dao.impl.CategoryDaoImpl_24162009;
import com.example.midterm.entity.Category_24162009;
import com.example.midterm.service.ICategoryService_24162009;
import java.util.List;

public class CategoryServiceImpl_24162009 implements ICategoryService_24162009 {
    private ICategoryDao_24162009 dao = new CategoryDaoImpl_24162009();
    public void insert(Category_24162009 c) { dao.insert(c); }
    public void update(Category_24162009 c) { dao.update(c); }
    public void delete(int id) { dao.delete(id); }
    public Category_24162009 findById(int id) { return dao.findById(id); }
    public List<Category_24162009> findAll(int offset, int limit) { return dao.findAll(offset, limit); }
    public int count() { return dao.count(); }
}
