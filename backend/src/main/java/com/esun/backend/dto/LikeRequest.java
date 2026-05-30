package com.esun.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// 前端新增或修改喜好商品時傳入的資料格式
public class LikeRequest {

    // 使用者 ID
    @NotBlank(message = "使用者ID不可空白")
    private String userId;

    // 商品流水號，對應 products 資料表的 no
    @NotNull(message = "商品流水號不可空白")
    private Integer productNo;

    // 扣款帳號
    @NotBlank(message = "扣款帳號不可空白")
    private String account;

    // 購買數量
    @NotNull(message = "購買數量不可空白")
    @Min(value = 1, message = "購買數量至少為1")
    private Integer purchaseQuantity;

    // 使用者備註
    private String remark;

    public String getUserId() {
        return userId;
    }

    public Integer getProductNo() {
        return productNo;
    }

    public String getAccount() {
        return account;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public String getRemark() {
        return remark;
    }
}