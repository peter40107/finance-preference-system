package com.esun.backend.repository;

import com.esun.backend.dto.ProductResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// 商品資料層
// 從 products 資料表查詢商品資料
@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    // 接收 JdbcTemplate 來查詢資料庫
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 查詢所有商品
    public List<ProductResponse> findAll() {

        String sql = """
                SELECT
                    no,
                    product_type,
                    product_code,
                    product_name,
                    price,
                    fee_rate
                FROM products
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new ProductResponse(
                        rs.getInt("no"),
                        rs.getString("product_type"),
                        rs.getString("product_code"),
                        rs.getString("product_name"),
                        rs.getBigDecimal("price"),
                        rs.getBigDecimal("fee_rate")
                )
        );
    }
}