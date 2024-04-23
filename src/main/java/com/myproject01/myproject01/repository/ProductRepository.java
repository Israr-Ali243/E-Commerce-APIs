package com.myproject01.myproject01.repository;

import com.myproject01.myproject01.dto.ProductDTO;
import com.myproject01.myproject01.entity.Category;
import com.myproject01.myproject01.entity.Product;
import com.myproject01.myproject01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByUser(User user);
    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.CategoryTitle = :keyword")
    public  List<Product> findByCategoryTitle(@Param("keyword") String keyword);



}
