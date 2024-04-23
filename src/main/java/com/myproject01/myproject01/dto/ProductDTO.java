package com.myproject01.myproject01.dto;

import com.myproject01.myproject01.entity.Category;
import com.myproject01.myproject01.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class ProductDTO {
//    private MultipartFile image;
    private int productId;
//    @Size(min = 2 , message = "Enter Name size Greater than 2 charcters")
    private String producttitle;
    private String  productDescription;
    private boolean inStock;
//    @Size(min = 1, message = "Price should be greater than 1")
    private int productPrice;
    private byte [] imageName;
    private String image;


}
