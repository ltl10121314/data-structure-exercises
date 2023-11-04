package com.example.demo.mapper;

import com.example.demo.domain.WaPayfileDoc;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-05-14 23:48
 * @description 薪资发放单详情
 */
@SpringBootTest
@Slf4j
public class WaPayFileDetailDaoTest {

    @Autowired
    private WaPayfileDocDao waPayfileDocDao;

    @Autowired(required = false)
    private IWaPayFileDetailDao payFileDetailDao;

    @Test
    void queryPayFileDocs() {
        String tenantId = "0000KWA1Q2DF1521B50000";
        String waPayFileId = "1658532107197087750";
        List<WaPayfileDoc> waPayfileDocs = waPayfileDocDao.queryPayfileDocs(tenantId, waPayFileId);
        List<String> staffIds = waPayfileDocs.stream().map(WaPayfileDoc::getStaffId).collect(Collectors.toList());
        log.info("查询员工：{}", staffIds);
    }

    @Test
    void queryItemValues() {
        // 查询发放单明细
        List<String> payfileDocIds = new ArrayList<>();
        payfileDocIds.add("1680034895253995554");
        payfileDocIds.add("1680034895253995553");
        List<String> payfileIds = new ArrayList<>();
        payfileIds.add("1680034895253995521");
        List<String> staffIds = null;
        Map<String,Object> condPayfileDetail = new HashMap();
        condPayfileDetail.put("pkPayfileDocs", payfileDocIds);
        condPayfileDetail.put("pkPayfiles", payfileIds);
        condPayfileDetail.put("staffIds", staffIds);
        String tableName = "wa_payfile_detail_0000L6YTYEY5FUZPXE0000";
        condPayfileDetail.put("tenantId", "0000L6YTYEY5FUZPXE0000");
        String columns = "f_n_1,f_n_2,f_n_3,f_n_5,f_n_9,f_n_11,f_n_12,f_n_13,f_n_15,f_n_16,f_n_17,f_n_21,f_n_18,f_n_20,f_n_19,f_b_1,f_n_200,f_n_1000,f_n_201,f_n_202,f_n_205,f_n_203,f_n_204,f_n_206,f_n_207,f_n_208,f_n_209,f_n_211,f_n_213,f_n_212,f_n_210";
        List<Map<String, Object>> maps = payFileDetailDao.queryItemValues(condPayfileDetail, tableName, columns);
        log.info(maps.toString());
    }

}
