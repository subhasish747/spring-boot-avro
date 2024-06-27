package com.org.util;

import com.learnavro.domain.generated.*;

import java.util.List;

public class DataHelper {

    public static CoffeeOrder getOrder(){
        return CoffeeOrder.newBuilder().setId(1)
                .setName("Expresso")
                .setStatus("ordered")
                .setStore(
                    getStore()
                ).setOrderLineItems(
                    getOrderLineItems()
                ).build();
    }


    public static Address getAddress(){
        return Address.newBuilder()
                .setAddressLine1("ABC Road")
                .setCity("Kolkata")
                .setStateProvince("WB")
                .setCountry("India")
                .build();
    }

    public static Store getStore(){
        return Store.newBuilder().setId(1)
                .setAddress(
                        getAddress()
                ).build();
    }

    public static List<OrderLineItem> getOrderLineItems(){
        return List.of(OrderLineItem.newBuilder().setName("coffe").
                setSize(Size.LARGE).setQuantity(1).build()
        )  ;
    }

}
