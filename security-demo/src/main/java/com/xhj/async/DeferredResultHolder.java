package com.xhj.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 熊厚谨 on 2018/5/31 20:37
 *
 * @author 熊厚谨
 */
@Component
public class DeferredResultHolder {
    // 模拟：string 对应订单号 DeferredResult是订单号对应的订单处理结果
    private Map<String,DeferredResult<String>> map = new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public DeferredResultHolder setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
        return this;
    }
}
