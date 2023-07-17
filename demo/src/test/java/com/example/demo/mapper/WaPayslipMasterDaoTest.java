package com.example.demo.mapper;

import com.example.demo.domain.WaPayslipmaster;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-05-16 14:06
 * @description 工资条
 */
@SpringBootTest
@Slf4j
public class WaPayslipMasterDaoTest {

    @Autowired
    private IWaPayslipMasterDao waPayslipMasterDao;

    @Test
    public void queryPayslipsDetailsByIdsTest() {
        List<String> list = new ArrayList<>();
        list.add("1700917000547074057");
        List<WaPayslipmaster> waPayslipmasters = waPayslipMasterDao.queryPayslipsDetailsByIds("0000L0GCJTKI6JSSV00000", list);
        log.info(waPayslipmasters.toString());
    }
}
