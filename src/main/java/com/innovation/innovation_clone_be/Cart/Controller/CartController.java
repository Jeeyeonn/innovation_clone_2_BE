package com.innovation.innovation_clone_be.Cart.Controller;


import com.innovation.innovation_clone_be.Cart.Dto.CartRequestDto;
import com.innovation.innovation_clone_be.Cart.Dto.CartUpdateRequestDto;
import com.innovation.innovation_clone_be.Cart.Service.CartService;
import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import com.innovation.innovation_clone_be.Product.Dto.Request.ProductRequestDto;
import com.innovation.innovation_clone_be.Product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    // 장바구니에 해당 상품 담기 (상품전체페이지)
    @PostMapping("/api/auth/cart")
    public ResponseDto<?> addCartProduct(@RequestBody ProductRequestDto requestDto, HttpServletRequest request){
        return cartService.addCartProduct(requestDto, request);
    }


    // 장바구니에 해당 상품 담기 (상세페이지)
    @PostMapping("/api/auth/main/products/cart")
    public ResponseDto<?> addCartDetailProduct(@RequestBody CartRequestDto requestDto, HttpServletRequest request){
        return cartService.addCartDetailProduct(requestDto, request);
    }


    // 나의 장바구니 목록 보여주기
    @GetMapping("/api/auth/mycart")
    public ResponseDto<?> getMyCart(HttpServletRequest request){
        return cartService.getMyCart(request);
    }

    //제품 수량 변경 (장바구니 페이지)
    @PutMapping("/api/auth/mycart")
    public ResponseDto<?> putMyCart(HttpServletRequest request, @RequestBody CartUpdateRequestDto requestDto){
        return cartService.putMyCart(request, requestDto);
    }

    // 나의 장바구니 목록 중 하나의 제품 삭제
    @DeleteMapping("/api/auth/mycart/{product_id}")
    public ResponseDto<?> deleteCart(@PathVariable Long product_id, HttpServletRequest request){
        return cartService.deleteCart(product_id, request);
    }

    // 나의 장바구니 목록 전체 삭제
    @DeleteMapping("/api/auth/mycart")
    public ResponseDto<?> deleteAllCart(HttpServletRequest request){
        return cartService.deleteAllCart(request);
    }

    //전체 제품 보여주기 (전체 상품 페이지)
    @GetMapping(value = "/api/main")
    public ResponseDto<?> getAllCart(HttpServletRequest request) {
        return cartService.getAllCart(request);
    }
}
