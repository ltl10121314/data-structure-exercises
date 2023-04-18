package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 发放单薪资档案
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WaPayfileDoc {
    public static final String TABLE_NAME = "wa_payfile_doc";
    private String pkWaPayfile;
    private String pkWaScheme;
    private String staffJobId;
    private String staffId;
    private String staffCode;
    private String staffName;
    private String orgId;
    private String orgName;
    private String deptId;
    private String deptName;
    private String choose;
    private int dr;
    private int approveFlag;
    private int calculateFlag;
    private int auditFlag;
    private String pkStaffDoc;
    private boolean isentry;
    private boolean isdimission;
    private boolean ischange;
    private String bankId;
    private String bankCode;
    private String bankName;
    private String bankAccount;
    private String bankModifiedtime;
    private String branchBankName;
    private BigDecimal payoll;
    private String dependPayfileId;
    private String dependApproveSortId;
    private String taxOrgId;
    private String payfileName;
    private int payFlag;
    private int overFlag;
    private String parentId = "";
    private Date beginDate;
    private Date endDate;
    private String tenantid;
    private String ytenantId;

}
