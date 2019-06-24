package com.github.spring.demo.controller;

import com.alibaba.fastjson.JSON;
import com.github.spring.demo.annotation.Log;
import com.github.spring.demo.model.Vender;
import com.github.spring.demo.service.IVenderService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Enumeration;

@RestController
@Slf4j
@RequestMapping(value = "/vender")
public class VenderController {

    @Autowired
    IVenderService venderService;

    @RequestMapping("/index")
    @ResponseBody
    @Log("index接口")
    public String index(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {//读取请求消息头
            String name = headerNames.nextElement();
            sb.append(name + ":" + request.getHeader(name) + "<br>");
        }
        return sb.toString();
    }

    /**
     * http://127.0.0.1:8080/vender/get?abc=121212
     *
     * @param request
     * @param response
     * @param abc
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    @Log("Get接口")
    public String getVender(HttpServletRequest request, HttpServletRequest response, @RequestParam(value = "abc", required = false) String abc) {
        log.info(">>get>>" + abc);

        venderService.get(1L);

        StringBuilder sb = new StringBuilder();
        sb.append(request.getMethod() + "<br>");
        sb.append(request.getQueryString() + "<br>");
        sb.append(request.getRequestURI() + "<br>");
        sb.append(request.getRequestURL() + "<br>");

        return sb.toString();
    }

    /**
     * http://127.0.0.1:8080/vender/post
     *
     * {
     * venderid:1L,
     * vendername:"aaaa"
     * }
     *
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public String postVender(HttpServletRequest request, @RequestBody String param) {
        log.info(">>post");

//        JSONObject jsonObject = JSONObject.parseObject(param);
        Vender vender = JSON.parseObject(param, Vender.class);

        StringBuilder sb = new StringBuilder();
        sb.append(request.getMethod() + "<br>");
        sb.append(request.getQueryString() + "<br>");
        sb.append(request.getRequestURI() + "<br>");
        sb.append(request.getRequestURL() + "<br>");

        log.info("venderId=" + vender.getVenderid());
        log.info("venderName=" + vender.getVendername());

        return sb.toString();
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String setVender(@Valid @Length(min = 1, max = 10) @RequestParam(value = "method", required = true) String method) {
        log.info(">>post");
        return "ok";
    }

}
