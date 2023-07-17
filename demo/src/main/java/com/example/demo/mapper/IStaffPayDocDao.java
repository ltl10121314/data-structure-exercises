package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 薪资档案Dao
 *
 * @author Colin
 **/
public interface IStaffPayDocDao {

    /**
     * @param staffId
     * @param jobId
     * @param tenantId
     * @return
     */
    Map<String, Object> getPartTypeByJobIdStaffId(@Param("staffId")String staffId, @Param("jobId")String jobId, @Param("tenantId")String tenantId);
}
