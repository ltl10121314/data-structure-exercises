package com.example.demo.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-05-18 12:27
 * @description 发薪人员
 */
@SpringBootTest
@Slf4j
public class StaffPayDocDaoTest {

    @Autowired
    private IStaffPayDocDao staffPayDocDao;

    @Test
    public void getPartTypeByJobIdStaffIdTest(){
        String staffId = "1705218418890244098";
        String staffJobId = "1706579296455753728";
        String tenantId = "0000LG4RO9P1HG4RGK0000";
        Map<String, Object> partType = staffPayDocDao.getPartTypeByJobIdStaffId(staffId, staffJobId, tenantId);
        System.out.println(partType);
        Map<String, String> map = new HashMap<>();
        System.out.println(map.get("hahah"));
    }

}
