package com.myproject01.myproject01.controller;



import com.myproject01.myproject01.dto.ProductDTO;

import com.myproject01.myproject01.service.CategoryService;
import com.myproject01.myproject01.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import com.myproject01.myproject01.utitls.qrCodeScanner;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;




@RestController
@RequestMapping(value = "/products")
@Tag(name = "Product-Controller")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
//    private   CategoryService categoryService;



    @PostMapping( "/add")
    @Operation(summary = "Add New Product")
    public ResponseEntity<ProductDTO> createProduct(@Valid @ModelAttribute ProductDTO productDTO, @RequestParam("file") MultipartFile file) throws IOException {
        ProductDTO productDTO1 = this.productService.CreateProduct(productDTO, 552, 1, file);
        return ResponseEntity.ok(productDTO1);
    }



    @GetMapping("/getall")
    @Operation(summary = "Find All Products")
    public ResponseEntity<List<ProductDTO>> getallproducts() throws Exception {
        List<ProductDTO> productDTOList =this.productService.getAllProducts();

        for (ProductDTO productDTO : productDTOList) { // it will genrate all QR-Code for all products
            qrCodeScanner.generateQRCode(productDTO);
        }

        return  ResponseEntity.ok(productDTOList);
    }



    @GetMapping("user/{userId}")
    @Operation(summary = "Find Products by UserID")
    public ResponseEntity<List<ProductDTO>> getProductByUser(@Valid @PathVariable("userId")  Integer Id){

        List<ProductDTO> productDTOList = this.productService.getProductByUser(Id);
        return ResponseEntity.ok(productDTOList);
    }


    @GetMapping("/find-product-by-category/{keyword}")
    @Operation(summary = "Find Product By Category")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable("keyword") String keyword){

        List<ProductDTO> productDTOList = this.productService.getProductByCategory(keyword);
//        System.out.println(productDTOList.get(0).getProducttitle());
        return ResponseEntity.ok(productDTOList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find Product By ID")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Integer id) throws Exception {
        ProductDTO productDTO = this.productService.getProductByID(id);
        qrCodeScanner.generateQRCode(productDTO);
        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "Delete Product By ID")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id){
        this.productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted Successfully");
    }


    //    @GetMapping ("category/get")
//    @Operation(summary = "Find ")
//    public ResponseEntity<List<CategoryDTO>> Home(Model model){
//          List<CategoryDTO> categoryDTOList = this.categoryService.getAllCategory();
//        System.out.println(categoryDTOList.toString());
//          model.addAttribute("category", categoryDTOList);
//        return ResponseEntity.ok(categoryDTOList);
//    }

}
