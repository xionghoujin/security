package com.xhj.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


/**
 * Created by 熊厚谨 on 2018/5/31 20:11
 *
 * @author 熊厚谨
 */
@RestController
public class AsyncController {
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    private Logger logger = LoggerFactory.getLogger(getClass());
//使用Callable
//    @RequestMapping("/order")
//    public Callable<String> order() throws InterruptedException {
//        logger.info("主线程开始");
//        //使用lambda表达式覆盖接口中的方法
//        Callable<String> result = () -> {
//            logger.info("副线程开始");
//            Thread.sleep(1000);
//            logger.info("副线程结束");
//            return "success";
//        };
//        logger.info("主线程结束");
//        return result;
//    }

    @RequestMapping("/order")
    public DeferredResult<String> order()   {
        logger.info("主线程开始");

        String orderNumeric = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumeric);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumeric,result );

        logger.info("主线程结束");
        return result;
    }

}
