package com.myproject01.myproject01.controller;

import com.myproject01.myproject01.dto.CartItemDTO;
import com.myproject01.myproject01.dto.CategoryDTO;
import com.myproject01.myproject01.entity.Category;
import com.myproject01.myproject01.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
@Slf4j
@Tag(name = "Category-Controller")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    @Operation(summary = "Add new Category")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("addCategory() -> request Recived");
        CategoryDTO categoryDTO1 = this.categoryService.createCategory(categoryDTO);
        log.info("addCategory() -> request completed Succefully");

       return ResponseEntity.ok(categoryDTO1);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Category Data")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") Integer Id){
       return ResponseEntity.ok(this.categoryService.updateCategory(categoryDTO, Id));
     }

     @DeleteMapping("/delete/{id}")
     @Operation(summary = "Delete Category")
     public String deleteCategory(@PathVariable("id") Integer Id){
        this.categoryService.deleteCategory(Id);
        return "Categeory Deleted Sucefully";
     }

     @GetMapping("/{id}")
     @Operation(summary = "Find Category By ID")
     public ResponseEntity<CategoryDTO> getCategoryByID(@PathVariable("id") Integer Id){
        return ResponseEntity.ok(this.categoryService.getCategoryById(Id));
     }

    @GetMapping("/getall")
    @Operation(summary = "Find All Categories")
    public ResponseEntity<List<CategoryDTO>> getCategorys(){
        List<CategoryDTO> list =  this.categoryService.getAllCategory();
        System.out.println(list);
//        model.addAttribute("category", list);
        return ResponseEntity.ok(this.categoryService.getAllCategory());
    }

}
