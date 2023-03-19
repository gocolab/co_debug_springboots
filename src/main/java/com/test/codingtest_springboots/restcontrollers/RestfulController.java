package com.test.codingtest_springboots.restcontrollers;

import org.springframework.web.bind.annotation.RestController;

import com.test.codingtest_springboots.service.CommonCodeOurService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.HashMap;

@RestController
@CrossOrigin
public class RestfulController {

    @RequestMapping(value = "/api/v1/helloworld", method = RequestMethod.GET)
    public String helloworld() {
        return "hello world !";
    }

    // params - title:"learn ajax!", description:"we learn with ajax!"
    @RequestMapping(value = "/api/v1/requestParams", method = RequestMethod.GET)
    public Map requestParams(@RequestParam Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.putAll(params);
        result.put("id", "yojulab");
        return result;
    }

    @Autowired
    CommonCodeOurService commonCodeOurService;

    // currentPage : 1
    @RequestMapping(value = "/api/v1/requestParamsWithDB", method = RequestMethod.POST)
    public Map requestParamsWithDB(@RequestParam Map<String, Object> params) {
        params.put("currentPage", Integer.parseInt((String) params.get("currentPage")));
        params.put("pageScale", 10);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap = (Map<String, Object>) commonCodeOurService.getListWithPagination(params);

        return resultMap;
    }
}