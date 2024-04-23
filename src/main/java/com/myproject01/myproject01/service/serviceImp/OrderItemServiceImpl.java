package com.myproject01.myproject01.service.serviceImp;

import com.myproject01.myproject01.dto.OrderItemDTo;
import com.myproject01.myproject01.repository.OrderItemRepository;
import com.myproject01.myproject01.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;
    @Override
    public OrderItemDTo CreateOrder(OrderItemDTo orderDTo) {

        return null;
    }

    @Override
    public OrderItemDTo getOrderbyId(Integer Id) {
        return null;
    }

    @Override
    public void DeleteOrderItem(Integer Id) {

    }
}
