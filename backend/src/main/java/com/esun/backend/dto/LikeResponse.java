package com.esun.backend.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

// 查詢喜好商品清單時回傳給前端的資料格式
public class LikeResponse {
    // 流水號
    private Integer sn;

    // 使用者資料
    private String userId;

    private String userName;

    private String email;

    // 商品資料
    // 商品流水號
    private Integer productNo;

    private String productType;

    private String productCode;

    private String productName;

    private Integer purchaseQuantity;

    // 預計扣款帳號
    private String account;

    // 總手續費
    private BigDecimal totalFee;

    // 預計扣款總金額
    private BigDecimal totalAmount;

    // 使用者備註
    private String remark;

    // 建立日期
    private Timestamp createdAt;

    // 將查詢到的資料放入欄位
    public LikeResponse(
            Integer sn,
            String userId,
            String userName,
            String email,
            Integer productNo,
            String productType,
            String productCode,
            String productName,
            Integer purchaseQuantity,
            String account,
            BigDecimal totalFee,
            BigDecimal totalAmount,
            String remark,
            Timestamp createdAt
    ) {
        this.sn = sn;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.productNo = productNo;
        this.productType = productType;
        this.productCode = productCode;
        this.productName = productName;
        this.purchaseQuantity = purchaseQuantity;
        this.account = account;
        this.totalFee = totalFee;
        this.totalAmount = totalAmount;
        this.remark = remark;
        this.createdAt = createdAt;
    }


    public Integer getSn() {
        return sn;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getProductNo() {  return productNo; }

    public Integer getPurchaseQuantity() {  return purchaseQuantity;  }

    public String getAccount() {  return account;  }

    public BigDecimal getTotalFee() {  return totalFee;  }

    public BigDecimal getTotalAmount() {  return totalAmount;  }

    public String getRemark() {  return remark;  }

    public Timestamp getCreatedAt() { return createdAt; }
}