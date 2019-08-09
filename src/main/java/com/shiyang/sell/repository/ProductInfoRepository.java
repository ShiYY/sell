package com.shiyang.sell.repository;

import com.shiyang.sell.dataobject.ProductInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: 商品信息
 * @author: W
 * @create: 2019-08-09 11:25
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    
    /**
     * 根据商品状态查询商品
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
