package com.innovation.innovation_clone_be.Product.Dto.Response;

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

}
