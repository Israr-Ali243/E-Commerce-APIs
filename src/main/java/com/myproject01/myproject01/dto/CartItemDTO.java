package com.myproject01.myproject01.dto;

import com.myproject01.myproject01.entity.Product;
import com.myproject01.myproject01.entity.User;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CartItemDTO {
    private int id;
    @Size(min = 1, message = "Quantity should be greater than 0")
    private int quantity;
    private long subtotal;
    private ProductDTO productDTO;
    private CategoryDTO categoryDTO;
}
