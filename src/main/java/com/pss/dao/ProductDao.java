package com.pss.dao;

import com.pss.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    List<Product> getAll(@Param("key") String key);
    int delete(@Param("id") int id);
    Product getProductById(@Param("id") int id);
    int update(@Param("product") Product product);
    int add(@Param("product") Product product);
    Product getProductByBarCode(@Param("barCode") String barCode);
    List<Product> getProductCount(@Param("id") int id);

}
