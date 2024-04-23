package com.myproject01.myproject01.service;

import com.myproject01.myproject01.dto.OrderItemDTo;

public interface OrderItemService {

    public OrderItemDTo CreateOrder(OrderItemDTo orderItemDTo);
    public OrderItemDTo getOrderbyId(Integer Id);
    public  void DeleteOrderItem(Integer Id);
}
