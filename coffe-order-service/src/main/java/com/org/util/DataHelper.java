package com.org.util;

import com.learnavro.domain.generated.*;

import java.util.List;

public class DataHelper {

    public static CoffeeOrder getOrder(){
        CoffeeOrder order =new CoffeeOrder();
        order.setId(1);
        order.setName("Expresso");
        order.setStatus("ordered");
        order.setNickName("cf");
        order.setStore(
                    getStore()
                );
        order.setOrderLineItems(
                    getOrderLineItems()
                );
        return order;
    }


    public static Address getAddress(){
        Address address =new Address();
        address.setAddressLine1("ABC Road");
        address.setCity("Kolkata");
        address.setStateProvince("WB");
        address.setCountry("India");
        address.setZip("700136");
        return address;
    }

    public static Store getStore(){
        Store store = new Store();
        store.setId(1);
        store.setAddress(
                getAddress()
        );
        return store;
    }

    public static List<OrderLineItem> getOrderLineItems(){
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setName("coffe");
        orderLineItem.setSize(Size.LARGE);
        orderLineItem.setQuantity(1);
        return List.of(orderLineItem
        )  ;
    }

}
