package com.innovation.innovation_clone_be.Product.Dto.Response;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailResponseDto {
    private Long productId;
    private String name;
    private String content;
    private int price;
    private String img1;

}
