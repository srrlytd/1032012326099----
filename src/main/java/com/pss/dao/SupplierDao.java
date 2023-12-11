package com.pss.dao;

import com.pss.bean.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierDao {
    List<Supplier> getAll(@Param("key") String key);
    int add(@Param("supplier") Supplier supplier);
    int delete(@Param("id") int id);
    Supplier getSupplierById(@Param("id") int id);
    int update(@Param("supplier") Supplier supplier);
}
