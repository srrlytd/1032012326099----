package com.pss.controller;

import com.pss.bean.Sale;
import com.pss.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.pss.bean.Stock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
public class SaleController {
    @Autowired
    private SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }
    @GetMapping("/sale/getAll")
    public ModelAndView getAll(String key){
        ModelAndView mv = new ModelAndView();
        List<Sale> saleList = saleService.getAll(key);
        mv.addObject("salelist",saleList);
        mv.setViewName("/view/sale/sale_list.jsp");
        return mv;
    }
    @PostMapping("/sale/sale")
    public ModelAndView sale(String productBarCode,float salePrice,String saleDate,int saleCount){
        Sale sale = new Sale(productBarCode,salePrice,saleDate,saleCount,salePrice*saleCount, LocalDateTime.now(),LocalDateTime.now(),0);
        Stock stock = new Stock(productBarCode,saleCount,LocalDateTime.now(),LocalDateTime.now(),0, UUID.randomUUID().toString());
        Stock record = new Stock(productBarCode,LocalDateTime.now(),LocalDateTime.now(),0,saleCount,"销售");
        ModelAndView mv = new ModelAndView();
        Boolean r = saleService.sale(sale,stock,record);
        if(r){
            mv.setViewName("/view/sale/sale_result.jsp");
        }else {
            mv.setViewName("/view/sale/sale_error.jsp");
        }
        return mv;
    }
}
