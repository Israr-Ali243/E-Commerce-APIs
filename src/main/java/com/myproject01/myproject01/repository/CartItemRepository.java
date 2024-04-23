package com.myproject01.myproject01.repository;

import com.myproject01.myproject01.entity.cartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<cartItem,Long> {
}
