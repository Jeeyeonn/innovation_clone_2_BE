package com.innovation.innovation_clone_be.Product.Dto.Response;

import com.innovation.innovation_clone_be.Product.Entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailResponseDto {
    private Long productId;
    private String name;
    private String content;
    private int price;
    private String img1;

    public ProductDetailResponseDto(Product product){
        this.productId = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.img1 = product.getImg1();
        this.content = product.getContent();
    }
}
