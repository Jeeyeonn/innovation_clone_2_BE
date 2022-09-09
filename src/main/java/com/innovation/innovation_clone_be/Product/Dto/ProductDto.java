package com.innovation.innovation_clone_be.Product.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String name;
    private String content;
    private String img1;
    private String img2;
    private int cartNum;
    private int price;
}
