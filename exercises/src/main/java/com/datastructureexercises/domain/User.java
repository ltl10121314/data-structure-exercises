package com.datastructureexercises.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liutianlong
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String id;
    private String code;
    private String name;
    private String age;
    private String address;
}
