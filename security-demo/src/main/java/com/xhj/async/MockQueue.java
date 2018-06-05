package com.xhj.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 熊厚谨 on 2018/5/31 20:33
 *
 * @author 熊厚谨
 */
@Component
public class MockQueue {
    //代表下单
    private String placeOrder;
    //代表订单完成
    private String completeOrder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder)  {
        //开一个线程单独执行
            new Thread(()->{
                logger.info("接到下单请求，"+placeOrder);
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("下单请求处理完毕，" + placeOrder);

            }).start();
            //修改completeOrder！
        this.completeOrder =placeOrder;
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public MockQueue setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
        return this;
    }
}
