package com.datastructureexercises.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private int orderId;
    private Date creationTime;
}
