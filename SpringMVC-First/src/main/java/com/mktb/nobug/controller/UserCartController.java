package com.mktb.nobug.controller;

import com.mktb.nobug.entity.Goods;
import com.mktb.nobug.entity.User;
import com.mktb.nobug.entity.UserCart;
import com.mktb.nobug.entity.UserCartView;
import com.mktb.nobug.service.GoodsService;
import com.mktb.nobug.service.OrdersService;
import com.mktb.nobug.service.UserCartService;
import com.mktb.nobug.service.UserCartViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.channels.NotYetBoundException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserCartController {
    @Autowired
    private UserCartService userCartService;

    @Autowired
    private UserCartViewService userCartViewService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/addToCart")
    public String addToCart(int goods_id, double price, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("---addToCart-----");
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        response.setContentType("text/html;charset=utf-8");
        if (now_user == null) {
            return "login.jsp";
        } else {
            Goods goods = goodsService.selectById(goods_id);

            if (goods.getStock() == 0) {
                response.getWriter().write("商品存货不足！");
                response.setHeader("refresh", "1;url=/allGoods");
            }

            List<UserCart> userCartById = userCartService.getUserCartById(now_user.getUser_id());
            boolean flag = false;
            for (UserCart userCart : userCartById) {
                if (userCart.getGoods_id() == goods_id) {
                    int num = userCartService.getGoodStock(userCart.getCart_id());
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("goods_stock", num + 1);
                    double newTotalPrice = (num + 1) * price;
                    hashMap.put("usercart_id", userCart.getCart_id());
                    hashMap.put("new_price", newTotalPrice);
                    userCartService.updateGoodStock(hashMap);
                    flag = true;
                }
            }
            if (!flag) {
                UserCart userCart = new UserCart(userCartService.getNextId(), now_user.getUser_id(), goods_id, 1, new Date(new java.util.Date().getTime()), price);
                userCartService.addUserCart(userCart);
            }
            return "redirect:/allGoods";
        }
    }

    @RequestMapping("/myCart")
    public String myCart(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        if (now_user == null) {
            return "login.jsp";
        } else {
            List<UserCartView> allCartById = userCartViewService.getAllCartById(now_user.getUser_id());

            for (UserCartView userCartView : allCartById) {
                System.out.println(userCartView);
            }

            model.addAttribute("myCart", allCartById);
            return "mycart.jsp";
        }
    }

    @RequestMapping("removeCart")
    public String remove(int goods_id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        if (now_user == null) {
            return "login.jsp";
        } else {
            userCartService.deleteByGoodsId(now_user.getUser_id(), goods_id);
            return "/myCart";
        }
    }

    @ResponseBody
    @RequestMapping("/add")
    public void addNum(int cart_id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("add");
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        response.setContentType("text/html;charset=utf-8");
        if (now_user == null) {
            response.setHeader("refresh", "0;url=login.jsp");
        } else {
            UserCart byCartId = userCartService.getByCartId(cart_id);
            Goods goods = goodsService.selectById(byCartId.getGoods_id());

            if (goods.getStock() < byCartId.getGoods_stock() + 1) {
                response.getWriter().write("货物不足！");
                response.setHeader("refresh", "1;url=/myCart");
            } else {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("goods_stock", byCartId.getGoods_stock() + 1);
                double newTotalPrice = (byCartId.getGoods_stock() + 1) * goods.getPrice();
                hashMap.put("usercart_id", byCartId.getCart_id());
                hashMap.put("new_price", newTotalPrice);
                userCartService.updateGoodStock(hashMap);
                response.setHeader("refresh", "0;url=/myCart");
            }
        }
    }

    @ResponseBody
    @RequestMapping("/down")
    public void down(int cart_id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("down");
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        response.setContentType("text/html;charset=utf-8");
        if (now_user == null) {
            response.setHeader("refresh", "0;url=login.jsp");
        } else {
            UserCart byCartId = userCartService.getByCartId(cart_id);
            Goods goods = goodsService.selectById(byCartId.getGoods_id());

            if (byCartId.getGoods_stock() <= 1) {
                response.getWriter().write("客官，不能再减少了！");
                response.setHeader("refresh", "1;url=/myCart");
            } else {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("goods_stock", byCartId.getGoods_stock() - 1);
                double newTotalPrice = (byCartId.getGoods_stock() - 1) * goods.getPrice();
                hashMap.put("usercart_id", byCartId.getCart_id());
                hashMap.put("new_price", newTotalPrice);
                userCartService.updateGoodStock(hashMap);
                response.setHeader("refresh", "0;url=/myCart");
            }
        }
    }
}
