package com.example.midterm.service.impl;
import com.example.midterm.dao.IProductDao_24162009;
import com.example.midterm.dao.impl.ProductDaoImpl_24162009;
import com.example.midterm.entity.Product_24162009;
import com.example.midterm.service.IProductService_24162009;
import java.util.List;

public class ProductServiceImpl_24162009 implements IProductService_24162009 {
    private IProductDao_24162009 dao = new ProductDaoImpl_24162009();
    public List<Product_24162009> findAll() { return dao.findAll(); }
    public List<Product_24162009> findAll(int offset, int limit) { return dao.findAll(offset, limit); }
    public Product_24162009 findById(int id) { return dao.findById(id); }
    public void insert(Product_24162009 p) { dao.insert(p); }
    public void update(Product_24162009 p) { dao.update(p); }
    public void delete(int id) { dao.delete(id); }
    public int count() { return dao.count(); }
}
