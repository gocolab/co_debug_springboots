package com.test.codingtest_springboots.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.codingtest_springboots.dao.CommonCodeDao;
import com.test.codingtest_springboots.utils.Paginations;

@Service
@Transactional
public class CommonCodeService {
    @Autowired
    CommonCodeDao commonCodeDao;

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
        result = this.getListWithPagination(dataMap);
        return result;
    }

    public Object insertWithFilesAndGetList(Object dataMap) {
        // insert files
        Object result = attachFileService.insertMulti(dataMap);
        result = this.insertOne(dataMap);
        result = this.getListWithPagination(dataMap);
        return result;
    }

    public Object getListWithPagination(Object dataMap) {
        int totalCount = (int) this.getTotal(dataMap);

        Object objCurrentPage = ((Map<String, Object>) dataMap).get("currentPage");
        int currentPage = 1;
        if (objCurrentPage != null) {
            currentPage = Integer.parseInt((String) objCurrentPage);
        }
        Paginations paginations = new Paginations(totalCount, currentPage);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("paginations", paginations);

        ((Map<String, Object>) dataMap).put("pageBegin", paginations.getPageBegin());
        ((Map<String, Object>) dataMap).put("pageScale", paginations.getPageScale());
        result.put("resultList", this.getList(dataMap));
        return result;
    }

    public Object getTotal(Object dataMap) {
        String sqlMapId = "CommonCode.selectTotal";

        Object result = commonCodeDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object getList(Object dataMap) {
        String sqlMapId = "CommonCode.selectListByUID";
        Object result = commonCodeDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object getOne(Object dataMap) {
        String sqlMapId = "CommonCode.selectByUID";

        Object result = commonCodeDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object updateOne(Object dataMap) {
        String sqlMapId = "CommonCode.updateByUID";

        Object result = commonCodeDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object insertOne(Object dataMap) {
        String sqlMapId = "CommonCode.insertWithUID";

        Object result = commonCodeDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object delete(Object dataMap) {
        String sqlMapId = "CommonCode.deleteByUID";

        Object result = commonCodeDao.delete(sqlMapId, dataMap);
        return result;
    }

    public Object deleteMulti(Object dataMap) {
        String sqlMapId = "CommonCode.deleteMultiByUIDs";

        Object result = commonCodeDao.delete(sqlMapId, dataMap);
        return result;
    }
}