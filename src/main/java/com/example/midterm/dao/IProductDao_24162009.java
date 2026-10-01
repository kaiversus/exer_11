package com.example.midterm.dao;
import com.example.midterm.entity.Product_24162009;
import java.util.List;
public interface IProductDao_24162009 {
    List<Product_24162009> findAll();
    List<Product_24162009> findAll(int offset, int limit);
    Product_24162009 findById(int id);
    void insert(Product_24162009 p);
    void update(Product_24162009 p);
    void delete(int id);
    int count();
}