package com.pss.service;

import com.pss.bean.Product;
import com.pss.bean.Purchase;
import com.pss.bean.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getAll(@Param("key") String key);
    boolean input(@Param("product") Product product, @Param("purchase") Purchase purchase, @Param("stock") Stock stock, @Param("record") Stock record);
}
