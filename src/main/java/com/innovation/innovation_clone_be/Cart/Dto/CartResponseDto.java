package com.innovation.innovation_clone_be.Cart.Dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDto {
    private Long productId;
    private String name;
    private int price;
    private int count;
    private Boolean pack;
    private String img1;

    private Boolean isChecked;

}
