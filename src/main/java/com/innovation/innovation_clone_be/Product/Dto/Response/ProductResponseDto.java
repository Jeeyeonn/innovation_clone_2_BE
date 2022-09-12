package com.innovation.innovation_clone_be.Product.Dto.Response;

import com.innovation.innovation_clone_be.Product.Entity.Product;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private Long productId;
    private String name;
    private int price;
    private String img1;
    private String img2;

    public ProductResponseDto(Product product){
        this.productId = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.img1 = product.getImg1();
        this.img2 = product.getImg2();
    }
}
