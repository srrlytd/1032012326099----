package com.pss.dao;

import com.pss.bean.Purchase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseDao {
    List<Purchase> getAll(@Param("key") String key);
    int add(@Param("purchase") Purchase purchase);
}
