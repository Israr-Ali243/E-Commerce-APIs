package com.myproject01.myproject01.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class OrderItemDTo {
    private int OrderId;
    private String status;
    private Long TotalPrice;
    private Long ProductQuantity;
}
