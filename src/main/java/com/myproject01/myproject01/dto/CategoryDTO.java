package com.myproject01.myproject01.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDTO {

    private int categoryid;
    @Size(min = 4 , message = "Categrory Title should be greater than 4 character")
    private String categoryTitle;
    private String categoryDescribtion;
}
