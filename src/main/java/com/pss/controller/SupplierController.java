package com.pss.controller;

import com.pss.bean.Supplier;
import com.pss.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @GetMapping("/supplier/getAll")
    public ModelAndView getAll(String key){
        ModelAndView mv = new ModelAndView();
        if(key==null){
            key="";
        }
        List<Supplier> supplierList = supplierService.getAll(key);
        mv.addObject("supplierlist",supplierList);
        mv.setViewName("/view/supplier/supplier_list.jsp");
        return mv;
    }
    @PostMapping("/supplier/add")
    public String add(String supplierName,String address,String contactsName,String tel){
        Supplier supplier = new Supplier(supplierName,contactsName,tel,address, LocalDateTime.now(),LocalDateTime.now(),0);
        int i = supplierService.add(supplier);
        return "redirect:getAll";
    }
    @GetMapping("/supplier/delete")
    public String delete(int id){
        supplierService.delete(id);
        return "redirect:getAll";
    }
    @GetMapping("/supplier/getSupplierById")
    public ModelAndView getSupplierById(int id){
        Supplier supplier = supplierService.getSupplierById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("supplier",supplier);
        mv.setViewName("/view/supplier/supplier_update.jsp");
        return mv;
    }
    @PostMapping("/supplier/update")
    public String update(int id,String supplierName,String contactsName,String tel,String address){
        Supplier supplier = new Supplier(id,supplierName,contactsName,tel,address,LocalDateTime.now());
        supplierService.update(supplier);
        return "redirect:getAll";
    }
}
