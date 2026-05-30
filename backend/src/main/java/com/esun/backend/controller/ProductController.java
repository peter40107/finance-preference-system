package com.esun.backend.controller;

import com.esun.backend.dto.ProductResponse;
import com.esun.backend.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 商品展示層
// 提供前端查詢商品清單的 API
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ProductController {

    private final ProductService productService;

    // 接收 Service 供 Controller 使用
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 查詢所有金融商品
    @GetMapping("/api/products")
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }
}