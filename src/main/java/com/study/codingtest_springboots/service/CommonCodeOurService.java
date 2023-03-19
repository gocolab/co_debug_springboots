package com.study.codingtest_springboots.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.codingtest_springboots.dao.CommonCodeOurDao;
import com.study.codingtest_springboots.utils.Paginations;

@Service
@Transactional
public class CommonCodeOurService {
    @Autowired
    CommonCodeOurDao commonCodeOurDao;

    @Autowired
    AttachFileService attachFileService;

    public Object getOneWithAttachFiles(Object dataMap) {
        // Attach files ArrayList<Map>
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("attachFiles", attachFileService.getList(dataMap));

        // 기존 값 보존 위해 사용
        result.putAll((Map<String, Object>) this.getOne(dataMap));
        return result;
    }

    public Object deleteAndGetList(Object dataMap) {
        Object result = this.delete(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    public Object insertWithFilesAndGetList(Object dataMap) {
        // insert files
        Object result = attachFileService.insertMulti(dataMap);
        result = this.insertOne(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    public Object getListWithPagination(Object dataMap) {
        Map<String, Object> result = new HashMap<String, Object>();
        int totalCount = (int) this.getTotal(dataMap);
        int currentPage = (int) ((Map<String, Object>) dataMap).get("currentPage");
        Paginations paginations = new Paginations(totalCount, currentPage);
        result.put("paginations", paginations);
        ((Map<String, Object>) dataMap).put("pageBegin", paginations.getPageBegin());
        result.put("resultList", this.getList(dataMap));
        return result;
    }

    public Object getTotal(Object dataMap) {
        String sqlMapId = "CommonCodeOur.selectTotal";

        Object result = commonCodeOurDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object getList(Object dataMap) {
        String sqlMapId = "CommonCodeOur.selectListByUID";
        Object result = commonCodeOurDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object getOne(Object dataMap) {
        String sqlMapId = "CommonCodeOur.selectByUID";

        Object result = commonCodeOurDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object updateOne(Object dataMap) {
        String sqlMapId = "CommonCodeOur.updateByUID";

        Object result = commonCodeOurDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object insertOne(Object dataMap) {
        String sqlMapId = "CommonCodeOur.insertWithUID";

        Object result = commonCodeOurDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object delete(Object dataMap) {
        String sqlMapId = "CommonCodeOur.deleteByUID";

        Object result = commonCodeOurDao.delete(sqlMapId, dataMap);
        return result;
    }

    public Object deleteMulti(Object dataMap) {
        String sqlMapId = "CommonCodeOur.deleteMultiByUIDs";

        Object result = commonCodeOurDao.delete(sqlMapId, dataMap);
        return result;
    }
}