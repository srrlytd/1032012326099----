package com.pss.controller;

import com.pss.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.pss.bean.Stock;
import java.util.List;

@Controller
public class StockController {
    @Autowired
    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    @GetMapping("/stock/getAll")
    public ModelAndView getAll(String key){
        ModelAndView mv = new ModelAndView();
        List<Stock> stockList = stockService.getAll(key);
        mv.addObject("stocklist",stockList);
        mv.setViewName("/view/stock/stock_list.jsp");
        return mv;
    }
    @GetMapping("/stock/record")
    public ModelAndView record(String key){
        ModelAndView mv = new ModelAndView();
        List<Stock> re = stockService.record(key);
        mv.addObject("re",re);
        mv.setViewName("/view/stock/stock_recorder.jsp");
        return mv;
    }
}
