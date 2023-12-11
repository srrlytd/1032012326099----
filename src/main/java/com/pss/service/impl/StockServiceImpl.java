package com.pss.service.impl;

import com.pss.bean.Stock;
import com.pss.dao.StockDao;
import com.pss.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockDao stockDao;

    public StockServiceImpl(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Override
    public List<Stock> getAll(String key) {
        return stockDao.getAll(key);
    }

    @Override
    public List<Stock> record(String key) {
        return stockDao.record(key);
    }
}