package com.example.demo.mapper;

import com.example.demo.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-03-02 23:01
 * @description 学生接口
 */
@Mapper
public interface StudentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return 对象列表
     */
    List<Student> queryAll(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    int batchUpdate(@Param("tableName") String tableName, @Param("values")List<Map<String, Object>> values);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    Integer deleteById(String id);

}

