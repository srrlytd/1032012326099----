package com.pss.controller;

import com.pss.bean.Role;
import com.pss.bean.User;
import com.pss.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping("/role/getAll")
    public ModelAndView getAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.getAll();
        mv.addObject("rolelist",roleList);
        mv.setViewName("/view/user/user_add.jsp");
        return mv;
    }
}
