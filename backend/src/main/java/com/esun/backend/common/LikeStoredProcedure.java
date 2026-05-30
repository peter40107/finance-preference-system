package com.esun.backend.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 共用層
// 放置 H2 Stored Procedure 使用的方法
public class LikeStoredProcedure {

    // 查詢喜好商品清單
    public static ResultSet findAllLikes(Connection connection)
            throws SQLException {

        String sql = """
                SELECT
                    l.sn,
                    u.user_id,
                    u.user_name,
                    u.email,
                    l.product_no,
                    p.product_type,
                    p.product_code,
                    p.product_name,
                    l.purchase_quantity,
                    l.account,
                    l.total_fee,
                    l.total_amount,
                    l.remark,
                    l.created_at           
                FROM like_list l
                JOIN users u
                    ON l.user_id = u.user_id
                JOIN products p
                    ON l.product_no = p.no
                """;

        PreparedStatement statement =
                connection.prepareStatement(sql);

        return statement.executeQuery();
    }
}