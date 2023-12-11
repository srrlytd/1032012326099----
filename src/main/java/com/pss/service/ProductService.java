package com.pss.service;

import com.pss.bean.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> getAll(String key);
    int delete(@Param("id") int id);
    Product getProductById(@Param("id") int id);
    int update(@Param("product") Product product);
    Product getProductByBarCode(@Param("barCode") String barCode);
    int add(@Param("product") Product product);


}
