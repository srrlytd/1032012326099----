package com.pss.service;

import com.pss.bean.Sale;
import org.apache.ibatis.annotations.Param;
import com.pss.bean.Stock;
import java.util.List;

public interface SaleService {
    List<Sale> getAll(@Param("key") String key);
    boolean sale(@Param("sale") Sale sale,@Param("stock") Stock stock,@Param("record") Stock record);
}
