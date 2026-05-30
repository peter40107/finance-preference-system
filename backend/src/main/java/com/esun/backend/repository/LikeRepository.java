package com.esun.backend.repository;

import com.esun.backend.dto.LikeResponse;
import com.esun.backend.dto.ProductResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

// 喜好資料層
// 負責與資料庫進行查詢、新增、修改、刪除
@Repository
public class LikeRepository {

    private final JdbcTemplate jdbcTemplate;

    public LikeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 查詢喜好商品資料
    public List<LikeResponse> findAll() {

        String sql = """
        CALL FIND_ALL_LIKES()
        """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new LikeResponse(
                        rs.getInt("sn"),
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("email"),
                        rs.getInt("product_no"),
                        rs.getString("product_type"),
                        rs.getString("product_code"),
                        rs.getString("product_name"),
                        rs.getInt("purchase_quantity"),
                        rs.getString("account"),
                        rs.getBigDecimal("total_fee"),
                        rs.getBigDecimal("total_amount"),
                        rs.getString("remark"),
                        rs.getTimestamp("created_at")
                )
        );
    }

    // 依照商品流水號查詢商品資料
    public ProductResponse findProductByNo(Integer productNo) {

        String sql = """
                SELECT
                    no,
                    product_type,
                    product_code,
                    product_name,
                    price,
                    fee_rate
                FROM products
                WHERE no = ?
                """;

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new ProductResponse(
                        rs.getInt("no"),
                        rs.getString("product_type"),
                        rs.getString("product_code"),
                        rs.getString("product_name"),
                        rs.getBigDecimal("price"),
                        rs.getBigDecimal("fee_rate")
                ),
                productNo
        );
    }


    // 新增喜好清單資料
    public void insertLike(
            String userId,
            Integer productNo,
            Integer purchaseQuantity,
            String account,
            BigDecimal totalFee,
            BigDecimal totalAmount,
            String remark
    ) {
        String sql = """
                INSERT INTO like_list (
                    user_id,
                    product_no,
                    purchase_quantity,
                    account,
                    total_fee,
                    total_amount,
                    remark
                )
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                userId,
                productNo,
                purchaseQuantity,
                account,
                totalFee,
                totalAmount,
                remark
        );
    }

    // 依照流水號刪除個人喜好商品資料
    public void deleteLike(Integer sn) {

        String sql = """
                DELETE FROM like_list
                WHERE sn = ?
                """;

        jdbcTemplate.update(sql, sn);
    }

    // 修改喜好清單資料
    public void updateLike(
            Integer sn,
            Integer productNo,
            Integer purchaseQuantity,
            String account,
            BigDecimal totalFee,
            BigDecimal totalAmount,
            String remark
    ) {
        String sql = """
                UPDATE like_list
                SET
                    product_no = ?,
                    purchase_quantity = ?,
                    account = ?,
                    total_fee = ?,
                    total_amount = ?,
                    remark = ?,
                    updated_at = CURRENT_TIMESTAMP
                WHERE sn = ?
                """;

        jdbcTemplate.update(
                sql,
                productNo,
                purchaseQuantity,
                account,
                totalFee,
                totalAmount,
                remark,
                sn
        );
    }
}
