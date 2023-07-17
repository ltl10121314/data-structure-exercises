package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-03-02 23:00
 * @description 学生实体
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student  {
//    private static final long serialVersionUID = -91969758749726312L;
    /**
     * 唯一标识id
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
}
