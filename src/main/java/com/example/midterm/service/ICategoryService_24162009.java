package com.example.midterm.service;
import com.example.midterm.entity.Category_24162009;
import java.util.List;
public interface ICategoryService_24162009 {
    void insert(Category_24162009 c);
    void update(Category_24162009 c);
    void delete(int id);
    Category_24162009 findById(int id);
    List<Category_24162009> findAll(int offset, int limit);
    int count();
}