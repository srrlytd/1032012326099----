package com.pss.service.impl;

import com.pss.bean.Product;
import com.pss.dao.ProductDao;
import com.pss.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll(@Param("key") String key) {
        return productDao.getAll(key);
    }

    @Override
    public int delete(@Param("id") int id) {
        return productDao.delete(id);
    }

    @Override
    public Product getProductById(@Param("id") int id) {
        return productDao.getProductById(id);
    }

    @Override
    public int update(Product product) {
        return productDao.update(product);
    }

    @Override
    public Product getProductByBarCode(String barCode) {
        return productDao.getProductByBarCode(barCode);
    }

    @Override
    public int add(Product product) {
        return productDao.add(product);
    }


}
