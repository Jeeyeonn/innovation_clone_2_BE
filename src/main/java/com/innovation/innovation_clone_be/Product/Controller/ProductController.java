package com.innovation.innovation_clone_be.Product.Controller;
import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import com.innovation.innovation_clone_be.Product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //상품 목록 전체 보여주기 (상품전체페이지)
    @GetMapping("/api/main/products")
    public ResponseDto<?> getAllProduct(){
        return productService.getAllProduct();
    }

    // 장바구니에 해당 상품 담기 (상품전체페이지)
    //로그인 구현 후 HTTP 매개변수 넣기 --------------------------------------
    @PostMapping("/api/auth/cart")
    public ResponseDto<?> addCartProduct(){

    }
}