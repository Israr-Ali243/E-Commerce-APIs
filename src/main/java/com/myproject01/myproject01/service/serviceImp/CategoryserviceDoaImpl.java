package com.myproject01.myproject01.service.serviceImp;

import com.myproject01.myproject01.dto.CategoryDTO;
import com.myproject01.myproject01.entity.Category;
import com.myproject01.myproject01.exception.ResourceNotFoundException;
import com.myproject01.myproject01.repository.CategoryRepository;
import com.myproject01.myproject01.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryserviceDoaImpl  implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = this.categoryRepository.save(this.dtoTOCategory(categoryDTO));
        return this.CategoryToDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer Id) {
        if(categoryDTO==null){
            throw new ResourceNotFoundException("user", "id", Long.valueOf(Id));
        }
        Optional<Category> category =this.categoryRepository.findById(Long.valueOf(Id));

        if (category.isPresent()){
            Category updateCategory = category.get();
            updateCategory.setCategoryDescribtion(categoryDTO.getCategoryDescribtion());
            updateCategory.setCategoryTitle(categoryDTO.getCategoryTitle());
            this.categoryRepository.save(updateCategory);
            return this.CategoryToDTO(updateCategory);
        }
        return null;
    }

    @Override
    public void deleteCategory(Integer Id) {
        this.categoryRepository.deleteById(Long.valueOf(Id));
    }

    @Override
    public CategoryDTO getCategoryById(Integer Id) {

        Optional<Category> category = this.categoryRepository.findById(Long.valueOf(Id));

        Category category1 =category.get();

        return this.CategoryToDTO(category1);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categoryList = this.categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList =categoryList.stream().map(category -> this.CategoryToDTO(category)).collect(Collectors.toList());


        return categoryDTOList;
    }

    public CategoryDTO CategoryToDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryid(category.getCategoryId());
        categoryDTO.setCategoryTitle(category.getCategoryTitle());
        categoryDTO.setCategoryDescribtion(category.getCategoryDescribtion());
        return categoryDTO;
    }

    public Category dtoTOCategory(CategoryDTO categoryDTO){
        Category category = new Category();

        category.setCategoryId(categoryDTO.getCategoryid());
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescribtion(categoryDTO.getCategoryDescribtion());
        return category;
    }
}
