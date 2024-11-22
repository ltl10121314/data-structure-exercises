package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author liutianlong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentParamVO implements Serializable {

    private Boolean hasPayPeriod;

    private String staffPayDocStatus;

    private List<String> ids;

    private String name;

}
