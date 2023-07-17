package com.example.demo.mapper;

import com.example.demo.domain.Student;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author liutianlong
 */
@Mapper
public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return 返回用户实体
     */
    List<User> findAll();

    /**
     * 插入学生信息
     *
     * @param student 学生
     * @return 学生
     */
    int insert(Student student);

    /**
     * 根据ID批量查询用户信息
     *
     * @param condition 条件
     * @return 用户信息
     */
    List<User> findById(@Param("condition") Map<String, Object> condition);

    /**
     * 根据ID查询用户
     * @param condition
     * @return
     */
    User findUserById(@Param("condition") Map<String, Object> condition);
}
