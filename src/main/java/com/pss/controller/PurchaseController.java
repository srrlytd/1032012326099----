package com.pss.controller;

import com.pss.bean.Category;
import com.pss.bean.Product;
import com.pss.bean.Purchase;
import com.pss.bean.Supplier;
import com.pss.service.CategoryService;
import com.pss.service.ProductService;
import com.pss.service.PurchaseService;
import com.pss.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.pss.bean.Stock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SupplierService supplierService;
    @GetMapping("/purchase/getAll")
    public ModelAndView getAll(String key){
        ModelAndView mv = new ModelAndView();
        List<Purchase> purchaseList = purchaseService.getAll(key);
        mv.addObject("purchaselist",purchaseList);
        mv.setViewName("/view/purchase/purchase_list.jsp");
        return mv;
    }
    @GetMapping("/purchase/gotoInput")
    public ModelAndView gotoInput(){
        List<Category> categoryList = categoryService.getAll("");
        List<Supplier> supplierList = supplierService.getAll("");
        ModelAndView mv = new ModelAndView();
        mv.addObject("categorylist",categoryList);
        mv.addObject("supplierlist",supplierList);
        mv.setViewName("/view/purchase/purchase_input.jsp");
        return mv;
    }
    @PostMapping("/purchase/input")
    public ModelAndView input(String barCode,String productName,float purchasePrice,String purchaseDate,String proDate,String expDate,int count,float salePrice,int supplierId,int categoryId){
        ModelAndView mv = new ModelAndView();
        Product product = new Product(barCode,supplierId,categoryId,productName,salePrice, LocalDateTime.now(),LocalDateTime.now(),0);
        Purchase purchase = new Purchase(purchaseDate,proDate,expDate,purchasePrice,count,purchasePrice*count,LocalDateTime.now(),LocalDateTime.now(),0);
        Stock stock = new Stock(barCode,count,LocalDateTime.now(),LocalDateTime.now(),0, UUID.randomUUID().toString());
        Stock record = new Stock(barCode,LocalDateTime.now(),LocalDateTime.now(),0,count,"进货");
        Boolean msg = purchaseService.input(product,purchase,stock,record);
        if(msg){
            mv.setViewName("/view/purchase/input_result.jsp");
        }else {
            mv.setViewName("/view/purchase/input_error.jsp");
        }
        return mv;
    }
}
