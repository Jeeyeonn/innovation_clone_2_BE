package com.innovation.innovation_clone_be.Cart.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequestDto {
    private Long productId;
    private int count;
    private Boolean pack;
}
