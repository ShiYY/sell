package com.shiyang.sell.controller;

import com.shiyang.sell.dataobject.ProductCategory;
import com.shiyang.sell.dataobject.ProductInfo;
import com.shiyang.sell.service.impl.ProductCategoryServiceImpl;
import com.shiyang.sell.service.impl.ProductInfoServiceImpl;
import com.shiyang.sell.utils.ResultVOUtil;
import com.shiyang.sell.vo.ProductInfoVO;
import com.shiyang.sell.vo.ProductVO;
import com.shiyang.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 买家商品操作
 * @author: W
 * @create: 2019-08-09 14:46
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;
    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 1.查询所有上架商品
        List<ProductInfo> upAll = productInfoService.findUpAll();
        // 2.查询类目(一次性查询) 不要发数据库的查询放到for循环中 一旦循环的数据过大 数据库查询时间开销很大
        List<Integer> categoryTypeList = upAll.stream().map(p -> p.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categories = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        // 3.数据拼装

        List<ProductVO> data = new ArrayList<>();
        categories.stream().forEach(c -> {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(c.getCategoryType());
            productVO.setCategoryName(c.getCategoryName());

            List<ProductInfoVO> infos = new ArrayList<>();
            upAll.stream().forEach(p -> {
                if (p.getCategoryType().equals(c.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(p, productInfoVO);
                    infos.add(productInfoVO);
                }
            });

            productVO.setProductInfoVOList(infos);
            data.add(productVO);
        });

        return ResultVOUtil.success(data);
        // 测试数据
        /*ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("successful");
        ProductVO productVO = new ProductVO();
        List<ProductInfoVO> list = new ArrayList<>();
        ProductInfoVO productInfoVO = new ProductInfoVO();
        productInfoVO.setProductId("1");
        productInfoVO.setProductName("幽兰拿铁");
        productInfoVO.setProductPrice(new BigDecimal(15.00));
        productInfoVO.setProductDescription("奶茶状元");
        productInfoVO.setProductIcon("icon...");
        list.add(productInfoVO);
        productVO.setProductInfoVOList(list);
        resultVO.setData(productVO);
        return resultVO;*/
    }
}
