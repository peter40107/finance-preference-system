-- 使用者測試資料
INSERT INTO users (
    user_id,
    user_name,
    email,
    account,
    bio
)
VALUES (
           'A123456789',
           '許小偉',
           'peter40107@gmail.com',
           '00001234567890',
           '喜歡穩定投資 ETF '
       );

-- 商品測試資料
INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES (
           'ETF',
           '0050',
           '元大台灣50',
           104.25,
           0.020
       );

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES (
           'ETF',
           '0056',
           '元大高股息',
           50.20,
           0.010
       );

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('ETF',
        '00878',
        '國泰永續高股息',
        21.50,
        0.010);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('ETF',
        '00919',
        '群益台灣精選高息',
        24.80,
        0.0010);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('ETF',
        '006208',
        '富邦台50',
        108.00,
        0.0050);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('基金',
        'F001',
        '全球科技基金',
        50.00,
        0.0150);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('基金',
        'F002',
        '美國成長基金',
        65.00,
        0.0130);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('基金',
        'F003',
        '亞洲收益基金',
        38.00,
        0.0120);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('債券',
        'B001',
        '美國公債ETF',
        42.00,
        0.0008);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('債券',
        'B002',
        '投資級公司債ETF',
        36.00,
        0.0009);

-- 喜好清單測試資料
INSERT INTO like_list (
    user_id,
    product_no,
    purchase_quantity,
    account,
    total_fee,
    total_amount,
    remark
)
VALUES (
           'A123456789',
           1,
           10,
           '00001234567890',
           1.80,
           1801.80,
           '長期定期定額'
       );