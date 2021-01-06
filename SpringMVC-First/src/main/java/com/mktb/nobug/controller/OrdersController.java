package com.mktb.nobug.controller;

import com.mktb.nobug.dao.UserAddressDao;
import com.mktb.nobug.entity.*;
import com.mktb.nobug.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Controller
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersViewService ordersViewService;

    @Autowired
    private UserAddressService userAddressService;


    @RequestMapping("/myBills")
    public String myBills(HttpServletRequest request, Model model) {
        System.out.println("MyBills");
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        if (now_user == null) {
            return "login.jsp";
        } else {
            List<OrdersView> allOrders = ordersViewService.getAllOrders(now_user.getUser_id());
            for (OrdersView allOrder : allOrders) {
                System.out.println(allOrder);
            }
            model.addAttribute("myOrders", allOrders);
            return "bills.jsp";
        }
    }

    @ResponseBody
    @RequestMapping("/addToOrders")
    public void addToOrders(int cart_id, int goods_id, int quantity, double order_price, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("addToOrders");
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=utf-8");
        User now_user = (User) session.getAttribute("userStatue");
        if (now_user == null) {
            response.setHeader("refresh", "0;url=/login.jsp");
        } else {
            UserAddress userAddressByUserId = userAddressService.getUserAddressByUserId(now_user.getUser_id());

            if (userAddressByUserId == null) {
                response.getWriter().write("下单请先填写个人地址");
                response.setHeader("refresh", "1;url=/myAddress");
            } else {
                if (ordersService.addToOrders(cart_id, goods_id, quantity, order_price, userAddressByUserId.getUser_address_id(), now_user)) {
                    response.setHeader("refresh", "0;url=/myCart");
                } else {
                    response.getWriter().write("商品存货不足，下单失败");
                    response.setHeader("refresh", "1;url=/myCart");
                }
            }
        }
    }

    @RequestMapping("/mySellOrders")
    public String mySellOrders(int seller_id, HttpServletRequest request, Model model, HttpServletResponse response) {
        System.out.println("mySellOrders");
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        response.setContentType("text/html;charset=utf-8");
        if (now_user == null) {
            return "login.jsp";
        } else {
            List<SellOrder> sellOrders = ordersService.mySellOrders(seller_id);
            for (SellOrder sellOrder : sellOrders) {
                System.out.println(sellOrder);
            }
            model.addAttribute("sellOrder", sellOrders);
            return "seller.jsp";
        }
    }

    @ResponseBody
    @RequestMapping("delOrders")
    public void delOrders(int order_id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        response.setContentType("text/html;charset=utf-8");
        if (now_user == null) {
            response.setHeader("refresh", "0;url=/login.jsp");
        } else {
            Orders orderById = ordersService.getOrderById(order_id);
            if (orderById.getOrder_state() == 2 || orderById.getOrder_state() == 3) {
                response.getWriter().write("订单无法取消，请拒收货物，商品退回卖家后，订单自动取消！");
                response.setHeader("refresh", "2;url=/myBills");
            } else {
                ordersService.deleteOrders(orderById.getOrder_id());
                response.setHeader("refresh", "0;url=/myBills");
            }
        }
    }

    @RequestMapping("/pay")
    public String payGoods(int order_id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        if (now_user == null) {
            return "/login.jsp";
        } else {
            ordersService.updatePayTime(order_id);
            return "/myBills";
        }
    }

    @RequestMapping("delivery")
    public String deliveryGoods(int order_id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        if (now_user == null) {
            return "/login.jsp";
        } else {
            ordersService.updateDeliveryTime(order_id);
            return "/mySellOrders?seller_id=" + now_user.getUser_id();
        }
    }

    @ResponseBody
    @RequestMapping("done")
    public void doneGoods(int order_id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        response.setContentType("text/html;charset=utf-8");
        if (now_user == null) {
            response.setHeader("refresh", "0;url=/login.jsp");
        } else {
            Orders orderById = ordersService.getOrderById(order_id);
            int order_state = orderById.getOrder_state();
            if (order_state == 0 || order_state == 1) {
                response.getWriter().write("卖家未发货！");
                response.setHeader("refresh", "1;url=/myBills");
            } else {
                ordersService.updateDoneTime(order_id);
                response.setHeader("refresh", "0;url=/myBills");
            }
        }
    }
}
