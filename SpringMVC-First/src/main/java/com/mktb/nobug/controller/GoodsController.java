package com.mktb.nobug.controller;

import com.alibaba.fastjson.JSON;
import com.mktb.nobug.entity.Goods;
import com.mktb.nobug.entity.User;
import com.mktb.nobug.service.GoodsService;
import com.mktb.nobug.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/allGoods")
    public String getAllGoods(Model model) {
        System.out.println("AllGoods");
        List<Goods> goodsList = goodsService.getGoodsList();
        goodsList.removeIf(goods -> goods.getStock() == 0);
        model.addAttribute("allGoods", goodsList);
        return "index.jsp";
    }

    @RequestMapping("/upload")
    public String uploadPicture(String goods_name, String description, double price, int stock, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        if (now_user == null) {
            return "login.jsp";
        } else {
            String path = request.getServletContext().getRealPath("/images/goods");
            File realPath = new File(path);

            if (!realPath.exists()) {
                realPath.mkdir();
            }

            System.out.println(realPath);
            String name = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()) + file.getOriginalFilename();

            file.transferTo(new File(realPath + "/" + name));

            String totalName = "./images/goods/" + name;

            Goods goods = new Goods(goodsService.getNextId(), goods_name, description, stock,
                    new java.sql.Date(new Date().getTime()), price, totalName, now_user.getUser_id());
            goodsService.addGood(goods);
            return "/allGoods";
        }
    }

//    @RequestMapping("/newGoods")
//    public String newGoods(String goods_name, String description, double price, int stock, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        User now_user = (User) session.getAttribute("userStatue");
//        if (now_user == null) {
//            return "login.jsp";
//        } else {
//            String goodsPictureName = (String) session.getAttribute("goodsPictureName");
//            Goods goods = new Goods(goodsService.getNextId(), goods_name, description, stock,
//                    new java.sql.Date(new Date().getTime()), price, goodsPictureName, now_user.getUser_id());
//            goodsService.addGood(goods);
//            return "/allGoods";
//        }
//    }

    @RequestMapping("/myGoods")
    public String myGoods(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User now_user = (User) session.getAttribute("userStatue");
        if (now_user == null) {
            return "login.jsp";
        } else {
            List<Goods> goodsBySellerId = goodsService.getGoodsBySellerId(now_user.getUser_id());
            model.addAttribute("mySellGoods", goodsBySellerId);
            return "mysellgoods.jsp";
        }
    }
}
