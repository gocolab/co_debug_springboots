package com.test.codingtest_springboots.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.test.codingtest_springboots.service.CommonCodeService;
import com.test.codingtest_springboots.utils.CommonUtils;

@Controller
@RequestMapping(value = "/commonCode")
public class CommonCodeController {

    @Autowired
    CommonCodeService commonCodeService;

    @Autowired
    CommonUtils commonUtils;

    @RequestMapping(value = { "/insert" }, method = RequestMethod.POST)
    public ModelAndView insert(MultipartHttpServletRequest multipartHttpServletRequest,
            @RequestParam Map<String, Object> params, ModelAndView modelAndView) throws IOException {

        String registerSeq = multipartHttpServletRequest.getParameter("REGISTER_SEQ");

        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file_first");
        String fileName = multipartFile.getOriginalFilename();

        String relativePath = "src\\main\\resources\\static\\files\\";
        // file 저장
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(relativePath + fileName));
        bufferedWriter.write(new String(multipartFile.getBytes()));
        bufferedWriter.flush();

        commonCodeService.insertOne(params);
        modelAndView.setViewName("commonCodes/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/updateMulti" }, method = RequestMethod.POST)
    public ModelAndView updateMulti(MultipartHttpServletRequest multipartHttpServletRequest,
            @RequestParam Map<String, Object> params, ModelAndView modelAndView) throws IOException {

        params.put("attachfiles", commonUtils.getFilesInformation(multipartHttpServletRequest, params));

        Object resultMap = commonCodeService.updateWithFilesAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);

        modelAndView.setViewName("commonCodes/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/insertMulti" }, method = RequestMethod.POST)
    public ModelAndView insertMulti(MultipartHttpServletRequest multipartHttpServletRequest,
            @RequestParam Map<String, Object> params, ModelAndView modelAndView) throws IOException {

        params.put("attachfiles", commonUtils.getFilesInformation(multipartHttpServletRequest, params));

        Object resultMap = commonCodeService.insertWithFilesAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);

        modelAndView.setViewName("commonCodes/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/form" }, method = RequestMethod.GET)
    public ModelAndView form(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        modelAndView.setViewName("commonCodes/edit");
        return modelAndView;
    }

    @RequestMapping(value = { "/formMulti" }, method = RequestMethod.GET)
    public ModelAndView formMulti(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        modelAndView.setViewName("commonCodes/editMulti");
        return modelAndView;
    }

    @RequestMapping(value = { "/delete/{uniqueId}" }, method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Map<String, Object> params, @PathVariable String uniqueId,
            ModelAndView modelAndView) {
        params.put("COMMON_CODE_ID", uniqueId);
        Object resultMap = commonCodeService.deleteAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCodes/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/deleteMulti" }, method = RequestMethod.POST)
    public ModelAndView deleteMulti(HttpServletRequest httpServletRequest, @RequestParam Map<String, Object> params,
            ModelAndView modelAndView) {
        // modelAndView.addObject("resultMap", resultMap);
        String[] deleteMultis = httpServletRequest.getParameterMap().get("COMMON_CODE_ID");
        params.put("deleteMultis", deleteMultis);
        Object resultMap = commonCodeService.deleteMulti(params);

        modelAndView.setViewName("commonCodes/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/update" }, method = RequestMethod.POST)
    public ModelAndView update(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        commonCodeService.updateOne(params);
        modelAndView.setViewName("commonCodes/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public ModelAndView list(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = commonCodeService.getList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCodes/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/listPagination/{currentPage}", "" }, method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView listPagination(@RequestParam Map<String, Object> params,
            @PathVariable(required = false) String currentPage,
            ModelAndView modelAndView) {
        params.put("currentPage", currentPage);
        Object resultMap = commonCodeService.getListWithPagination(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCodes/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/edit/{uniqueId}" }, method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam Map<String, Object> params, @PathVariable String uniqueId,
            ModelAndView modelAndView) {
        params.put("COMMON_CODE_ID", uniqueId);
        Object resultMap = commonCodeService.getOne(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCodes/edit");
        return modelAndView;
    }

    @RequestMapping(value = { "/editMulti/{uniqueId}" }, method = RequestMethod.GET)
    public ModelAndView editMulti(@RequestParam Map<String, Object> params, @PathVariable String uniqueId,
            ModelAndView modelAndView) {
        params.put("COMMON_CODE_ID", uniqueId);
        params.put("SOURCE_UNIQUE_SEQ", uniqueId);
        Object resultMap = commonCodeService.getOneWithAttachFiles(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCodes/editMulti");
        return modelAndView;
    }
}
