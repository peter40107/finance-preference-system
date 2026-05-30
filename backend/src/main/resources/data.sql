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
           '喜歡長期穩定投資 ETF '
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
        30.76,
        0.010);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('個股',
        '2884',
        '玉山金',
        30.95,
        0.0010);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('個股',
        '2330',
        '台積電',
        2330.00,
        0.0050);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('個股',
        '2454',
        '聯發科',
        4310.00,
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
        8402.33,
        0.0130);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('基金',
        'F018',
        '亞洲收益基金',
        8080.17,
        0.0120);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('債券',
        'TLT',
        '長期美國公債ETF',
        2721.96,
        0.0008);

INSERT INTO products (
    product_type,
    product_code,
    product_name,
    price,
    fee_rate
)
VALUES ('債券',
        'IEF',
        '中期美國公債ETF',
        3000.10,
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