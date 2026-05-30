-- 使用者資料表
CREATE TABLE users (
                       user_id CHAR(10) PRIMARY KEY,
                       user_name VARCHAR(50) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       account VARCHAR(20) NOT NULL,
                       bio VARCHAR(300)
);

-- 商品資料表
CREATE TABLE products (
                          no INT AUTO_INCREMENT PRIMARY KEY,
                          product_type VARCHAR(30) NOT NULL,
                          product_code VARCHAR(20) NOT NULL,
                          product_name VARCHAR(100) NOT NULL,
                          price DECIMAL(15,2) NOT NULL,
                          fee_rate DECIMAL(5,4) NOT NULL
);

-- 喜好清單資料表
CREATE TABLE like_list (
                           sn INT AUTO_INCREMENT PRIMARY KEY,
                           user_id CHAR(10) NOT NULL,
                           product_no INT NOT NULL,
                           purchase_quantity INT NOT NULL,
                           account VARCHAR(20) NOT NULL,
                           total_fee DECIMAL(15,2) NOT NULL,
                           total_amount DECIMAL(15,2) NOT NULL,
                           remark VARCHAR(300),
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                           CONSTRAINT fk_user_like
                               FOREIGN KEY (user_id)
                                   REFERENCES users(user_id),

                           CONSTRAINT fk_product_like
                               FOREIGN KEY (product_no)
                                   REFERENCES products(no)
);

-- Stored Procedure
CREATE ALIAS FIND_ALL_LIKES
FOR "com.esun.backend.common.LikeStoredProcedure.findAllLikes";