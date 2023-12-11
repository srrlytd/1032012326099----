package com.pss.service.impl;

import com.pss.bean.Supplier;
import com.pss.dao.SupplierDao;
import com.pss.service.SupplierService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;

    public SupplierServiceImpl(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    @Override
    public List<Supplier> getAll(@Param("key") String key) {
        return supplierDao.getAll(key);
    }

    @Override
    public int add(Supplier supplier) {
        return supplierDao.add(supplier);
    }

    @Override
    public int delete(int id) {
        return supplierDao.delete(id);
    }

    @Override
    public Supplier getSupplierById(int id) {
        return supplierDao.getSupplierById(id);
    }

    @Override
    public int update(Supplier supplier) {
        return supplierDao.update(supplier);
    }
}
