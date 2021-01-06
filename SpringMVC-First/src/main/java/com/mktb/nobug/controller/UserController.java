package com.mktb.nobug.controller;

import com.alibaba.fastjson.JSON;
import com.mktb.nobug.entity.User;
import com.mktb.nobug.entity.UserAddress;
import com.mktb.nobug.service.UserAddressService;
import com.mktb.nobug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    private UserAddressService userAddressService;

    @ResponseBody
    @RequestMapping("/allUser")
    public String list(Model model) {
        List<User> userList = userService.getUserList();
        return JSON.toJSONString(userList);
    }

    @RequestMapping("/login")
    public void login(String user_phone, String user_pwd, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(user_phone);
        System.out.println(user_pwd);
        System.out.println(user_phone);
        User userByPhone = userService.getUserByPhone(user_phone);
        System.out.println(userByPhone);
        response.setContentType("text/html;charset=utf-8");
        if (userByPhone != null) {
            if (userByPhone.getUser_pwd().equals(user_pwd)) {
                HttpSession session = request.getSession();
                session.setAttribute("userStatue", userByPhone);
                response.setHeader("refresh", "0;url=/allGoods");
                //return "redirect:/allGoods";
            } else {
                response.getWriter().write("帐号或密码错误！");
                response.setHeader("refresh", "1;url=/login.jsp");
            }
        } else {
            response.getWriter().write("帐号未注册！");
            response.setHeader("refresh", "1;url=/login.jsp");
//            return JSON.toJSONString(toJSONString"帐号不存在");
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userStatue");
        return "redirect:/allGoods";
    }

    @RequestMapping("/register")
    public void register(String user_nick_name, String user_pwd, String user_phone, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User userByPhone = userService.getUserByPhone(user_phone);
        response.setContentType("text/html;charset=utf-8");
        if (userByPhone != null) {
            response.getWriter().write("该手机号已经注册，请登录");
            response.setHeader("refresh", "1;url=login.jsp");
        } else {
            User user = new User(userService.getNextId(), user_pwd, user_nick_name, "./images/users/default.png", user_phone, "1");
            userService.addUser(user);
            HttpSession session = request.getSession();
            session.setAttribute("userStatue", user);
            response.setHeader("refresh", "0;url=/allGoods");
        }
    }

    @RequestMapping("/myAddress")
    public String myAddress(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        if (now_user == null) {
            return "login.jsp";
        } else {
            UserAddress userAddressByUserId = userAddressService.getUserAddressByUserId(now_user.getUser_id());
            if (userAddressByUserId != null) {
                model.addAttribute("haveAddress", userAddressByUserId.getAddress());
            }
            return "/address.jsp";
        }
    }

    @RequestMapping("/newAddress")
    public String newAddress(String xiaoqu, String zhusuqu, String det_address, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        String address = xiaoqu + zhusuqu + det_address;
        if (now_user == null) {
            return "login.jsp";
        } else {
            UserAddress userAddressByUserId = userAddressService.getUserAddressByUserId(now_user.getUser_id());
            if (userAddressByUserId != null) {
                userAddressService.updateUserAddress(userAddressByUserId.getUser_address_id(), address);
            } else {
                UserAddress userAddress = new UserAddress(userAddressService.getNextId(), now_user.getUser_id(), address);
                userAddressService.addAddress(userAddress);
            }
            return "/allGoods";
        }
    }
}
