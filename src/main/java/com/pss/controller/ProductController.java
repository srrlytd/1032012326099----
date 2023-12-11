package com.pss.controller;

import com.pss.bean.Category;
import com.pss.bean.Product;
import com.pss.bean.Supplier;
import com.pss.service.CategoryService;
import com.pss.service.ProductService;
import com.pss.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/product/getAll")
     public ModelAndView getAll(String key){
        ModelAndView mv = new ModelAndView();
        if(key==null){
            key="";
        }
         List<Product> productList = productService.getAll(key);
         mv.addObject("productlist",productList);
         mv.setViewName("/view/product/product_list.jsp");
        return mv;
     }
     @GetMapping("/product/delete")
     public String delete(int id){
        productService.delete(id);
        return "redirect:getAll";
     }
     @GetMapping("/product/getProductById")
     public ModelAndView getProductById(int id){
        ModelAndView mv = new ModelAndView();
        Product product = productService.getProductById(id);
         System.out.println(product.toString());
        List<Supplier> supplierList = supplierService.getAll("");
        List<Category> categoryList = categoryService.getAll("");
        mv.addObject("product",product);
        mv.addObject("supplierlist",supplierList);
        mv.addObject("categorylist",categoryList);
        mv.setViewName("/view/product/product_update.jsp");
        return mv;
     }
     @PostMapping("/product/update")
     public String update(int id,String barCode,String productName,float salePrice,int supplierId,int categoryId){
        Product product = new Product(id,barCode,supplierId,categoryId,productName,salePrice, LocalDateTime.now());
        productService.update(product);
        return "redirect:getAll";
     }
}
