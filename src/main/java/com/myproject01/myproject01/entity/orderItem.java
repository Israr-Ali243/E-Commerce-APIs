package com.myproject01.myproject01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@NoArgsConstructor
@Setter
@Getter
public class orderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int OrderId;
    private Date orderDate;
    private String status;
    private Long TotalPrice;
    private Long ProductQuantity;


}
