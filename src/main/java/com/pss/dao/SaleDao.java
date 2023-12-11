package com.pss.dao;

import com.pss.bean.Sale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleDao {
    List<Sale> getAll(@Param("key") String key);
    int add(@Param("sale") Sale sale);
}
