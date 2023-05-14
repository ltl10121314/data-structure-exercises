package com.example.demo.mapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IWaPayFileDetailDao {

    List<Map<String, Object>> queryItemValues(@Param("cond") Map cond, @Param("tableName") String tableName, @Param("columns") String columns);
}
