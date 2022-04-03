package com.uin.utils;

import org.apache.log4j.Logger;


/**
 * @author wanglufei
 * @description: Log4j测试类
 * @date 2022/3/31/7:28 PM
 */
public class TestLogging {
    public static Logger logger = Logger.getLogger(TestLogging.class);

    public static void main(String[] args) {
        //使用默认的配置信息，不需要写log4j.properties
        // BasicConfigurator.configure();
        //设置日志输出级别为info，这将覆盖配置文件中设置的级别
        // logger.setLevel(Level.INFO);

        logger.info("info()...");
        logger.error("error()...");
        try {
            int a = 0;
            int b = 1 / 0;//0不能为除数，所以会走catch

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("0不能为除数", e);
        }
    }

}
