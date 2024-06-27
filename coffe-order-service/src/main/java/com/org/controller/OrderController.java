package com.org.controller;

import com.learnavro.domain.generated.CoffeeOrder;
import com.org.service.OrderProducer;
import com.org.util.DataHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/orders")
    public void sendOrder(@RequestBody CoffeeOrder order) {
        orderProducer.sendOrder(order);
    }

    @PostMapping("/test-order")
    public void sendOrder() {
        log.info("Inside /test-order");
        CoffeeOrder order = DataHelper.getOrder();
        log.info("Order {} ",order);
        orderProducer.sendOrder(order);
    }
}