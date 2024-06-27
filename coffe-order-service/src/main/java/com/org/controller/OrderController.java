package com.org.controller;

import com.learnavro.domain.generated.CoffeeOrder;
import com.org.service.OrderProducer;
import com.org.util.DataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/orders")
    public void sendOrder(@RequestBody CoffeeOrder order) {
        orderProducer.sendOrder(order);
    }

    @PostMapping("/test-order")
    public void sendOrder() {
        orderProducer.sendOrder(DataHelper.getOrder() );
    }
}