package com.pss.service.impl;

import com.pss.bean.Product;
import com.pss.bean.Purchase;
import com.pss.dao.ProductDao;
import com.pss.dao.PurchaseDao;
import com.pss.dao.StockDao;
import com.pss.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pss.bean.Stock;
import java.util.List;
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;

    public PurchaseServiceImpl(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }
    @Autowired
    private ProductDao productDao;
    @Autowired
    private StockDao stockDao;
    @Override
    public List<Purchase> getAll(String key) {
        return purchaseDao.getAll(key);
    }
    @Override
    @Transactional
    public boolean input(Product product, Purchase purchase,Stock stock,Stock record) {
        try {
            Boolean state = true;
            Product p = productDao.getProductByBarCode(product.getBarCode());
            if(p==null){
                productDao.add(product);
            }else {
                if(product.getProductName().equals(p.getProductName())){
                    Stock s = stockDao.getStockByBarCode(stock.getProductBarCode());
                    if(s==null){
                        stockDao.add(stock);
                    }else {
                        stock.setStockCount(s.getStockCount()+stock.getStockCount());
                        stockDao.updateCount(stock);
                    }

                    Product product1 = productDao.getProductByBarCode(product.getBarCode());
                    purchase.setProductId(product1.getId());
                    purchaseDao.add(purchase);
                    stockDao.addr(record);
                }else {
                    state=false;
                }
            }
            return state;

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
