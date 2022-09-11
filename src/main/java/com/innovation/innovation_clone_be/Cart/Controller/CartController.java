package com.innovation.innovation_clone_be.Cart.Controller;


import com.innovation.innovation_clone_be.Cart.Dto.CartRequestDto;
import com.innovation.innovation_clone_be.Cart.Service.CartService;
import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import com.innovation.innovation_clone_be.Product.Dto.Request.ProductRequestDto;
import com.innovation.innovation_clone_be.Product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    // 장바구니에 해당 상품 담기 (상품전체페이지)
    //로그인 구현 후 HTTP 매개변수 넣기 --------------------------------------
    @PostMapping("/api/auth/cart")
    public ResponseDto<?> addCartProduct(@RequestBody ProductRequestDto requestDto){
        return cartService.addCartProduct(requestDto);
    }


    // 장바구니에 해당 상품 담기 (상세페이지)
    //로그인 구현 후 HTTP 매개변수 넣기 --------------------------------------
    @PostMapping("/api/auth/main/products/{product_id}/cart")
    public ResponseDto<?> addCartDetailProduct(@PathVariable Long product_id, @RequestBody CartRequestDto requestDto){
        return cartService.addCartDetailProduct(product_id, requestDto);
    }


    // 나의 장바구니
    //로그인 구현 후 HTTP 매개변수 넣기 --------------------------------------
    @GetMapping("/api/auth/mycart")
    public ResponseDto<?> getMyCart(){
        return cartService.getMyCart();
    }

    @DeleteMapping("/api/auth/mycart/{product_id}")
    public ResponseDto<?> deleteCart(@PathVariable Long product_id){
        return cartService.deleteCart(product_id);
    }
}
