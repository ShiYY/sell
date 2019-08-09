package com.shiyang.sell.service.impl;

import com.shiyang.sell.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 买家商品操作
 * @author: W
 * @create: 2019-08-09 14:46
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @GetMapping("/list")
    public ResultVO list() {
    
        return null;
    }
}
