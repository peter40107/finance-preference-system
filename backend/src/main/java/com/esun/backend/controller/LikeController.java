package com.esun.backend.controller;

import com.esun.backend.dto.LikeRequest;
import com.esun.backend.dto.LikeResponse;
import com.esun.backend.service.LikeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

// 喜好展示層
// 負責接收前端 API 請求

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class LikeController {

    // 保存 Service，讓 Controller 可以呼叫以進行計算
    private final LikeService likeService;

    // 接收 Service 供 Controller 使用
    public LikeController(LikeService likeService) {

        this.likeService = likeService;
    }

    // 查詢喜好商品資料
    @GetMapping("/api/likes")
    public List<LikeResponse> findAll() {

        return likeService.findAll();
    }

    // 新增喜好商品資料
    @PostMapping("/api/likes")
    public String addLike(@RequestBody LikeRequest request) {
        likeService.createLike(request);
        return "新增成功";
    }

    // 刪除喜好商品資料
    @DeleteMapping("/api/likes/{sn}")
    public String deleteLike(@PathVariable Integer sn) {

        likeService.deleteLike(sn);

        return "刪除成功";
    }

    // 修改喜好商品資料
    @PutMapping("/api/likes/{sn}")
    public String updateLike(
            @PathVariable Integer sn,
            @RequestBody LikeRequest request
    ) {

        likeService.updateLike(sn, request);

        return "修改成功";
    }
}
