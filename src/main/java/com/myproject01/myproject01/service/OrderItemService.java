package com.myproject01.myproject01.service;

import com.myproject01.myproject01.dto.OrderItemDTo;

import java.util.List;

public interface OrderItemService {

    public OrderItemDTo CreateOrder(OrderItemDTo orderItemDTo);
    public OrderItemDTo getOrderbyId(Integer Id);
    public  boolean DeleteOrderItem(Integer Id);
    public List<OrderItemDTo> getall();
    public String UpdateOrder(OrderItemDTo orderItemDTo);
}
