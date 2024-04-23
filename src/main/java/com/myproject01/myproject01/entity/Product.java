package com.myproject01.myproject01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @Column(name = "productTitle")
    private String producttitle;
    private String  productDescription;
//    @Column(name = "imageName", nullable = false)
@Lob
@Column(columnDefinition = "LONGBLOB")
private byte[] imageName;
    private Date addDate;
    @Column(name = "InStock", nullable = false)
    private boolean InStock;
    @Column(name = "productPrice", nullable = false)
    private int productPrice;
    @ManyToOne()
    private Category category;
    @ManyToOne()
    private User user;





}
