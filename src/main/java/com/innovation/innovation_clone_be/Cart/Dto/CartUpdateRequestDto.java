package com.innovation.innovation_clone_be.Cart.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartUpdateRequestDto {
    private Long productId;
    private int count;
}
