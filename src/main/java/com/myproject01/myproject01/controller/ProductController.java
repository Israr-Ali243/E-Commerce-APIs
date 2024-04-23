package com.myproject01.myproject01.controller;



import com.myproject01.myproject01.ImageService;
import com.myproject01.myproject01.dto.CategoryDTO;
import com.myproject01.myproject01.dto.ProductDTO;
import com.myproject01.myproject01.entity.Category;
import com.myproject01.myproject01.service.CategoryService;
import com.myproject01.myproject01.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
 private   CategoryService categoryService;


    @GetMapping ("category/get")
    public ResponseEntity<List<CategoryDTO>> Home(Model model){
          List<CategoryDTO> categoryDTOList = this.categoryService.getAllCategory();
        System.out.println(categoryDTOList.toString());
          model.addAttribute("category", categoryDTOList);
        return ResponseEntity.ok(categoryDTOList);
    }



    @PostMapping( "/add")
    public ResponseEntity<ProductDTO> createProduct(@Valid @ModelAttribute ProductDTO productDTO, @RequestParam("file") MultipartFile file) throws IOException {

        ProductDTO productDTO1 = this.productService.CreateProduct(productDTO, 552, 1, file);
        return ResponseEntity.ok(productDTO1);
    }



    @GetMapping("/getall")
    public ResponseEntity<List<ProductDTO>> getallproducts(){
        List<ProductDTO> productDTOList =this.productService.getAllProducts();
        return  ResponseEntity.ok(productDTOList);
    }

// find all products by User. All users who add their products on your site.

    @GetMapping("user/{userId}")
    public ResponseEntity<List<ProductDTO>> getProductByUser(@Valid @PathVariable("userId")  Integer Id){

        List<ProductDTO> productDTOList = this.productService.getProductByUser(Id);
        return ResponseEntity.ok(productDTOList);
    }


    // Serach Product by Categority
    @GetMapping("/find-product-by-category/{keyword}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable("keyword") String keyword){

        List<ProductDTO> productDTOList = this.productService.getProductByCategory(keyword);
//        System.out.println(productDTOList.get(0).getProducttitle());
        return ResponseEntity.ok(productDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Integer id){
        ProductDTO productDTO = this.productService.getProductByID(id);
        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id){
        this.productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted Successfully");
    }



}
