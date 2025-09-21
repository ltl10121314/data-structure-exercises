package com.exercises.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liutianlong
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillData {

    private List<String> orgIds;

    public String orgId;
}
