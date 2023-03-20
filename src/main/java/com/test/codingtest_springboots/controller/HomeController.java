package com.test.codingtest_springboots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.codingtest_springboots.dao.HomeDao;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {

    @Autowired
    HomeDao homeDao;

    @RequestMapping(value = { "", "/", "/main" }) // http://localhost:8080/homejsp
    public String main() {
        int i = 0;
        return "main";
    }

    @RequestMapping(value = "/ajaxs/jQuery_ajaxReturnhellow")
    public String jQuery_ajaxReturnhellow() {
        int i = 0;
        return "ajaxs/jQuery_ajaxReturnhellow";
    }

    @RequestMapping(value = "/ajaxs/jQuery_ajaxParamsReturnMap")
    public String jQuery_ajaxParamsReturnMap() {
        int i = 0;
        return "ajaxs/jQuery_ajaxParamsReturnMap";
    }
}
