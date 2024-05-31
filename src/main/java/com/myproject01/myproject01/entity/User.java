package com.myproject01.myproject01.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @Column(name = "UserName", nullable = false)

    private String name;
    @Column(name = "uName", nullable = false)

    private String email;
    @Column(name = "uPassword", nullable = false)

    private String password;
    @Column(name = "uPhoneNumber")

    private String PhoneNumber;
    @Column(name = "Upic", nullable = false)
    private String UserPic="dft.png";
    @Column(name = "uAddress", nullable = false)
    private String UserAddress;



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> postList = new ArrayList<>();

}
