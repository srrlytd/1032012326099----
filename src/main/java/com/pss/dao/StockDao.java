package com.pss.dao;

import com.pss.bean.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockDao {
    List<Stock> getAll(@Param("key") String key);
    List<Stock> record (@Param("key") String key);
    Stock getStockByBarCode(@Param("barCode") String barCode);
    int add(@Param("stock")Stock stock);
    int addr(@Param("record") Stock record);
    int updateCount(@Param("stock") Stock stock);
}
