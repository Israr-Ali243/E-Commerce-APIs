package com.myproject01.myproject01.repository;

import com.myproject01.myproject01.dto.OrderItemDTo;
import com.myproject01.myproject01.entity.Category;
import com.myproject01.myproject01.entity.orderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<orderItem, Long> {
}
