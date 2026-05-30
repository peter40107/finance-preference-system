package com.esun.backend.service;

import com.esun.backend.dto.LikeRequest;
import com.esun.backend.dto.LikeResponse;
import com.esun.backend.dto.ProductResponse;
import com.esun.backend.repository.LikeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

// 喜好業務層
// 負責處理資料計算
@Service
public class LikeService {

    private final LikeRepository likeRepository;

    // 接收 Repository 來使用
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    // 查詢所有喜好商品資料
    public List<LikeResponse> findAll() {
        return likeRepository.findAll();
    }

    // 新增喜好商品
    // 加入 Transaction，避免新增時資料只成功一半
    @Transactional
    public void createLike(LikeRequest request) {

        // 依照商品流水號查詢商品資料
        ProductResponse product =
                likeRepository.findProductByNo(request.getProductNo());

        // 商品金額 = 商品價格 × 購買數量
        BigDecimal productAmount =
                product.getPrice().multiply(
                        BigDecimal.valueOf(
                                request.getPurchaseQuantity()
                        )
                );

        // 手續費 = 商品金額 × 手續費率
        BigDecimal totalFee =
                productAmount.multiply(
                        product.getFeeRate()
                );

        // 總扣款金額 = 商品金額 + 手續費
        BigDecimal totalAmount =
                productAmount.add(totalFee);

        // 新增喜好資料
        likeRepository.insertLike(
                request.getUserId(),
                request.getProductNo(),
                request.getPurchaseQuantity(),
                request.getAccount(),
                totalFee,
                totalAmount,
                request.getRemark()
        );
    }

    // 刪除喜好商品資料
    public void deleteLike(Integer sn) {
        likeRepository.deleteLike(sn);
    }

    // 修改喜好商品資料
    // 加入 Transaction，避免修改時資料只成功一半
    @Transactional
    public void updateLike(Integer sn, LikeRequest request) {

        // 依照商品流水號查詢商品資料
        ProductResponse product =
                likeRepository.findProductByNo(request.getProductNo());

        // 商品金額 = 商品價格 × 購買數量
        BigDecimal productAmount =
                product.getPrice().multiply(
                        BigDecimal.valueOf(request.getPurchaseQuantity())
                );

        // 手續費 = 商品金額 × 手續費率
        BigDecimal totalFee =
                productAmount.multiply(product.getFeeRate());

        // 總扣款金額 = 商品金額 + 手續費
        BigDecimal totalAmount =
                productAmount.add(totalFee);

        // 修改喜好清單資料
        likeRepository.updateLike(
                sn,
                request.getProductNo(),
                request.getPurchaseQuantity(),
                request.getAccount(),
                totalFee,
                totalAmount,
                request.getRemark()
        );
    }
}