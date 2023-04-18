package com.example.demo.mapper;

import com.example.demo.domain.WaPayfileDoc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-03-20 19:45
 * @description 薪资发放单人员档案
 */
@Mapper
public interface WaPayfileDocDao {

    /**
     * 查询薪资发放单人员档案的staff_Id
     * @param tenantId
     * @param waPayFileId
     * @return
     */
    List<WaPayfileDoc> queryPayfileDocs(@Param("tenantId") String tenantId, @Param("waPayFileId")String waPayFileId);
}
