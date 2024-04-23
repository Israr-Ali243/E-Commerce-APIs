package com.myproject01.myproject01.repository;

import com.myproject01.myproject01.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
