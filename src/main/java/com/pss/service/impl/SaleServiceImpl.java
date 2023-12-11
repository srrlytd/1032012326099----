package com.pss.service.impl;

import com.pss.bean.Sale;
import com.pss.bean.Stock;
import com.pss.dao.SaleDao;
import com.pss.dao.StockDao;
import com.pss.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.dc.pr.PRError;

import javax.swing.*;
import java.util.List;
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleDao saleDao;

    public SaleServiceImpl(SaleDao saleDao) {
        this.saleDao = saleDao;
    }
    @Autowired
    private StockDao stockDao;

    @Override
    public List<Sale> getAll(String key) {
        return saleDao.getAll(key);
    }

    @Override
    @Transactional
    public boolean sale(Sale sale, Stock stock, Stock record) {
        try {
            Stock s = stockDao.getStockByBarCode(stock.getProductBarCode());
            if(s==null||s.getStockCount()<sale.getSaleCount()){
                return false;
            }else {
                stock.setStockCount(s.getStockCount()-sale.getSaleCount());
                saleDao.add(sale);
                stockDao.updateCount(stock);
                stockDao.addr(record);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}
