package com.example.demo.mapper;

import com.example.demo.domain.WaPayslipmaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 薪资单DAO
 * 
 * @author : wangchao
 * @date : 2018年3月19日 下午3:06:35
 * @version : V1.0
 */
@Mapper
public interface IWaPayslipMasterDao {

    /**
     * 根据工资单id查询工资单详情
     *
     * @param tenantId 租户ID
     * @param ids 工资条ID
     * @return 工资单详情
     */
    List<WaPayslipmaster> queryPayslipsDetailsByIds(@Param("tenantId") String tenantId, @Param("ids") List<String> ids);
}
