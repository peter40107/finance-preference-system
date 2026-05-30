package com.esun.backend.service;

import com.esun.backend.dto.ProductResponse;
import com.esun.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// 商品業務層
// 提供商品清單給前端
@Service
public class ProductService {

    private final ProductRepository productRepository;

    // 接收 Repository 來使用
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 查詢所有商品
    public List<ProductResponse> findAll() {
        return productRepository.findAll();
    }
}