package com.innovation.innovation_clone_be.Cart.Dto;

import com.innovation.innovation_clone_be.Cart.Entity.Cart;
import com.innovation.innovation_clone_be.Member.Entity.Member;
import lombok.*;

@Getter
@Setter
public class CartResponseDto {
    private Long productId;
    private String name;
    private int price;
    private int count;
    private Boolean pack;
    private String img1;

    private Boolean isChecked;

    public CartResponseDto(Cart cart){
        this.productId = cart.getProduct().getId();
        this.name = cart.getProduct().getName();
        this.price = cart.getProduct().getPrice();
        this.count = cart.getCount();
        this.pack = cart.getPack();
        this.img1 = cart.getProduct().getImg1();
        this.isChecked = true;
    }
}
