package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 人员薪资档案
 * @author Colin
 *
 */
@Data
@AllArgsConstructor
public class StaffPayDoc {


    
    private String schemeAuthId;

    
    private String waSchemeName;

    
    private String staffId;

    
    private String staffJobId;

    
    private String orgId;

    
    private String taxOrgId;

    
    private String taxOrgName;

    
    private String taxDeptId;

    
    private String taxDeptName;

    
    private String orgName;

    
    private String deptId;

    
    private String deptName;

    
    private String postId;

    
    private String postName;

    
    private Date beginDate;

    
    private Date endDate;

    
    private Boolean partFlag;

    
    private Integer taxType;

    
    private String taxTableId;

    
    private Integer isDerate;

    
    private BigDecimal derateptg;

    
    private String staffCode;

    
    private String staffName;

    
    private Boolean lastFlag;

    
    private String insureId;

    
    private String perTaxOrgId;

    
    private String perTaxOrgName;

    
    private Integer hiredType;

    

    private String mainStaffJobId;

    

    private String bankName;

    

    private String bankAccount;

    

    private String categoryName;

    

    private String parttype;

    

    private Boolean ismainjob;

    

    private String newPostName;

    // DBIgnore，薪资方案名称(逗号分隔)
    private String schemaNames;

    // DBIgnore，变动类型-新进
    private Boolean isEntry;

    // DBIgnore，变动类型-离职
    private Boolean isDimission;

    // DBIgnore，变动类型-变动
    private Boolean isChange;
    //行号
    private Integer rowNum;
    // sheet页名字
    private String sheetName;
    // 代扣险种
    private String withholdInsurance;

    private String partType;    //其他任职类型id
    private String partTypeName;    //其他任职类型名称

    private Integer schemeTaxType;    //方案扣税方式
    private Boolean enable;    //方案是否启用

    

    private String waSchemaOrgName;

    public void setSchemaNames(String schemaNames) {
        this.schemaNames = schemaNames;
    }

    public StaffPayDoc() {}

}
