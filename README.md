金融商品喜好紀錄系統

介紹
本檔案為金融商品喜好紀錄系統，使用者可以從系統提供的金融商品清單中選擇商品加入自己的喜好清單。
系統會依照商品價格、手續費率及購買數量，自動計算預計扣款總金額與總手續費，並提供查詢、修改及刪除功能。
本專案以前後端兩者分離的方式開發，依照要求 : 前端使用 Vue，後端使用 Spring Boot，資料庫使用 H2。

使用技術

前端：

Vue 3
Vite
JavaScript

後端：

Spring Boot
Java 17
Maven
JdbcTemplate

資料庫：

H2 Database

系統功能

--查詢金融商品清單

系統提供已建立完成的金融商品資料，包含商品類型、商品代碼、商品名稱、商品價格及手續費率。

--新增喜好金融商品

使用者可選擇金融商品加入喜好清單，並於頂端欄位輸入：

使用者ID
扣款帳號
購買數量(最小為1)
備註(自由加入)

--系統會自動計算：

商品總金額
總手續費
預計扣款總金額

--使用者可查看預計購買之商品：

商品代碼
商品名稱
電子信箱
扣款帳號
購買數量
總手續費
預計扣款總金額
備註

--並可透過商品代碼或商品名稱進行搜尋已選擇的商品

--使用者也可以修改喜好金融商品包括:

扣款帳號
購買數量
備註

--系統會自動重新計算手續費及預計扣款總金額

--刪除喜好金融商品

使用者可刪除已加入的喜好商品資料，刪除前會跳出確認視窗避免誤刪。

系統架構

本專案採用簡單分層架構：

Vue Frontend

↓

Controller

↓

Service

↓

Repository

↓

H2 Database

各資料夾內檔案分別功能為:

Controller 負責接收前端請求。

Service 負責商業邏輯與金額計算。

Repository 負責資料庫查詢、新增、修改與刪除。

DTO 負責前後端資料傳遞。

資料表設計

本專案使用三張主要資料表：

users：使用者資料表

products：金融商品資料表

like_list：喜好商品資料表

喜好清單透過 user_id 關聯使用者資料，並透過 product_no 關聯商品資料。

API

GET /api/products

查詢金融商品清單

GET /api/likes

查詢喜好商品清單

POST /api/likes

新增喜好商品

PUT /api/likes/{sn}

修改喜好商品

DELETE /api/likes/{sn}

刪除喜好商品

其他要求實作內容
Transaction

新增與修改資料時使用 Transaction，避免資料只成功一半造成不一致。

SQL Injection 防護

使用 JdbcTemplate 參數化查詢，避免直接拼接 SQL 字串。

XSS 防護

前端使用 Vue 模板語法顯示資料，由 Vue 自動進行基本的 HTML Escape。

Stored Procedure

使用 H2 Database 的 CREATE ALIAS 實作 Stored Procedure 功能。

執行方式

Backend

進入 backend 資料夾：

mvn spring-boot

啟動後網址：

http://localhost:8080

H2 Console：

http://localhost:8080/h2-console

Frontend

進入 frontend 資料夾：

npm install

npm run dev

啟動後網址：

http://localhost:5173

測試資料

使用者ID：

請使用 A123456789

內建提供十筆商品於所有商品列表，一筆喜好商品測試資料於喜好商品列表，可直接進行加入喜好清單、刪除或新增等測試。