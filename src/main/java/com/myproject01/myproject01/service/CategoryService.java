package com.myproject01.myproject01.service;

import com.myproject01.myproject01.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    public CategoryDTO createCategory(CategoryDTO categoryDTO);
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer Id);
    public void deleteCategory(Integer Id);
    public CategoryDTO getCategoryById(Integer Id);
    public List<CategoryDTO> getAllCategory();
}
