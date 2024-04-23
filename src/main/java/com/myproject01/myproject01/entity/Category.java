package com.myproject01.myproject01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CategoryId;
    @Column(name = "CategoryTitle")
    private String CategoryTitle;
    private String CategoryDescribtion;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> postList = new ArrayList<>();
//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    private List<Product> postList = new ArrayList<>();


    @Override
    public String toString() {
        return "Category{" +
                "CategoryId=" + CategoryId +
                ", CategoryTitle='" + CategoryTitle + '\'' +
                ", CategoryDescribtion='" + CategoryDescribtion + '\'' +
                ", postList=" + postList +
                '}';
    }
}
