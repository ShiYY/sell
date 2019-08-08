package com.shiyang.sell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: 日志测试
 * @author: W
 * @create: 2019-08-07 15:12
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {
    
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    
    @Test
    public void test1() {
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
        /**
         * 默认只输出info级别以上的log  org.slf4j.event.Level类中定义类日志级别枚举
         * 2019-08-07 15:18:32.399  INFO 9304 --- [           main] com.shiyang.LoggerTest                   : info...
         * 2019-08-07 15:18:32.399 ERROR 9304 --- [           main] com.shiyang.LoggerTest                   : error...
         **/
    
        String name = "shiyang";
        String password = "123456";
        logger.info("name: {}, password: {}", name, password);
        /**
         * 2019-08-07 15:27:40.971  INFO 12836 --- [           main] com.shiyang.LoggerTest                   : name: shiyang, password: 123456
         */
    }
    
}
