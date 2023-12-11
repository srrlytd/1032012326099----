package com.pss.service;

import com.pss.bean.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockService {
    List<Stock> getAll(@Param("key") String key);
    List<Stock> record (@Param("key") String key);

}
