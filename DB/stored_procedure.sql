-- 使用 H2 Database 的 CREATE ALIAS 實作 Stored Procedure 功能
CREATE ALIAS FIND_ALL_LIKES
FOR "com.esun.backend.common.LikeStoredProcedure.findAllLikes";