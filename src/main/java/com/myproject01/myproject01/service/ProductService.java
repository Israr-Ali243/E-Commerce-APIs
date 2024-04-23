package com.myproject01.myproject01.service;

import com.myproject01.myproject01.dto.ProductDTO;
import com.myproject01.myproject01.entity.Category;
import com.myproject01.myproject01.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public interface ProductService {

    public ProductDTO CreateProduct(ProductDTO productDTO, Integer userID, Integer categoryID, MultipartFile file) throws IOException;
    public ProductDTO getProductByID(Integer ID);
    public List<ProductDTO> getAllProducts();
    public void deleteProduct(Integer Id);
    public ProductDTO updateProduct(ProductDTO productDTO, Integer Id);

    public List<ProductDTO> getProductByCategory(String keyword);
    public List<ProductDTO> getProductByUser(Integer userId);
    public List<ProductDTO> searchProduct(String keyword);


}
