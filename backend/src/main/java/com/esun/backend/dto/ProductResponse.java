package com.esun.backend.dto;

import java.math.BigDecimal;

// 商品清單回傳給前端的格式
public class ProductResponse {

    // 商品流水號
    private Integer no;

    // 商品類型
    private String productType;

    // 商品代碼
    private String productCode;

    // 商品名稱
    private String productName;

    // 商品價格
    private BigDecimal price;

    // 手續費率
    private BigDecimal feeRate;

    // 將商品資料放入欄位
    public ProductResponse(
            Integer no,
            String productType,
            String productCode,
            String productName,
            BigDecimal price,
            BigDecimal feeRate
    ) {
        this.no = no;
        this.productType = productType;
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.feeRate = feeRate;
    }

    public Integer getNo() {
        return no;
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

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }
}