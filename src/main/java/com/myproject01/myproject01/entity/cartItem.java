package com.myproject01.myproject01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Setter
@Getter
public class cartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartId")
    private int cartId;
    @Column(name = "Quanitiy")
    private int qty;
    @Column(name = "total")
    private long subtotal;

    @ManyToOne()
    @JoinColumn(nullable = true)
   private Product product;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private  User user;



}
