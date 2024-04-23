package com.myproject01.myproject01.controller;

import com.myproject01.myproject01.dto.CartItemDTO;
import com.myproject01.myproject01.dto.CategoryDTO;
import com.myproject01.myproject01.entity.Category;
import com.myproject01.myproject01.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/home")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("addCategory() -> request Recived");
        CategoryDTO categoryDTO1 = this.categoryService.createCategory(categoryDTO);
        log.info("addCategory() -> request completed Succefully");

       return ResponseEntity.ok(categoryDTO1);
    }
     @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") Integer Id){
       return ResponseEntity.ok(this.categoryService.updateCategory(categoryDTO, Id));
     }

     @DeleteMapping("/delete/{id}")
     public String deleteCategory(@PathVariable("id") Integer Id){
        this.categoryService.deleteCategory(Id);
        return "Categeory Deleted Sucefully";
     }

     @GetMapping("{id}")
     public ResponseEntity<CategoryDTO> getCategoryByID(@PathVariable("id") Integer Id){
        return ResponseEntity.ok(this.categoryService.getCategoryById(Id));
     }

    @RequestMapping("/admin")
    public ResponseEntity<Category> getCategorys(Model model){
        List<CategoryDTO> list =  this.categoryService.getAllCategory();
        System.out.println(list);
//        model.addAttribute("category", list);
        return ResponseEntity.ok((Category) this.categoryService.getAllCategory());
    }

}
