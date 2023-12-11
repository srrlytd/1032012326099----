package com.pss.controller;

import com.pss.bean.Role;
import com.pss.bean.User;
import com.pss.service.RoleService;
import com.pss.service.UserService;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserController() {
    }
    @Autowired
    private RoleService roleService;
    @PostMapping("/user/login")
    public ModelAndView login(String loginname,String password){
        User user = userService.login(loginname,password);
        ModelAndView mv = new ModelAndView();
        if(user!=null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            if(user.getRole_id()==1){
                mv.setViewName("redirect:/index.jsp");
            }else {
                mv.setViewName("redirect:/index2.jsp");
            }
        }else {
            mv.addObject("msg","用户名或密码错误");
            mv.setViewName("/login.jsp");
        }
        return mv;
    }
    @GetMapping("/user/getAll")
    public ModelAndView getAll(String key){
        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.getAll(key);
        mv.addObject("userlist",userList);
        mv.setViewName("/view/user/user_list.jsp");
        return mv;
    }
    @PostMapping("/user/add")
    public String add(String userName,int roleId,String loginAccount,String password,String tel,String wxAccount,String idNo,String address){
        User user = new User(roleId,userName,loginAccount,password,tel,wxAccount,idNo,address, LocalDateTime.now(),LocalDateTime.now(),0);
        userService.add(user);
        return "redirect:getAll";
    }
    @GetMapping("/user/deleted")
    public String deleted(int id){
        userService.deleted(id);
        return "redirect:getAll";
    }
    @GetMapping("/user/getUserById")
    public ModelAndView getUserById(int id){
        ModelAndView mv = new ModelAndView();
        User user = userService.getUserById(id);
        List<Role> roleList = roleService.getAll();
        mv.addObject("user",user);
        mv.addObject("rolelist",roleList);
        mv.setViewName("/view/user/user_update.jsp");
        return mv;
    }
    @PostMapping("/user/update")
    public String update(int id,String userName,String loginAccount,String password,String tel,String wxAccount,String idNo,String address,int roleId){
        User user = new User(id,roleId,userName,loginAccount,password,tel,wxAccount,idNo,address,LocalDateTime.now());
        userService.update(user);
        return "redirect:getAll";
    }
    @GetMapping("/user/exit")
    public ModelAndView exit(HttpSession session){
        session.removeAttribute("user");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login.jsp");
        return mv;
    }
}
