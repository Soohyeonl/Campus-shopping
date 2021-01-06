package com.mktb.nobug.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mktb.nobug.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("msg", "hello");
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/t1")
    public String test1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return mapper.writeValueAsString(sdf.format(date));
    }


    @ResponseBody
    @RequestMapping("/t2")
    public String test2() throws JsonProcessingException {
        Date date = new Date();

        return JsonUtils.getJson(date);
    }

    @ResponseBody
    @RequestMapping("/t3")
    public String test3() {
        /**
         *  Java 对象转 JSON字符串：
         *  String str1 = JSON.toJSONString(list)
         *
         *  JSON 字符串转 Java 对象
         *  User user = JSON.parseObject(str, User.class)
         *
         *  Java 对象转 JSON 对象
         *  JSONObject json = (JSONObject) JSON.toJSON(user)
         *
         *  JSON 对象转 Java对象
         *  User user = JSON.toJavaObject(jsonboject, User.class)
         *
         *
         */

        return "hhh";
    }
}
