package com.pss.service;

import com.pss.bean.Supplier;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAll(String key);
    int add(@Param("supplier") Supplier supplier);
    int delete(@Param("id") int id);
    Supplier getSupplierById(@Param("id") int id);
    int update(@Param("supplier") Supplier supplier);

}
