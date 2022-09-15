package com.innovation.innovation_clone_be.Product.Controller;

import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import com.innovation.innovation_clone_be.Product.Dto.Request.ProductDto;
import com.innovation.innovation_clone_be.Product.Dto.Request.ProductRequestDto;
import com.innovation.innovation_clone_be.Product.Entity.Product;
import com.innovation.innovation_clone_be.Product.Repository.ProductRepository;
import com.innovation.innovation_clone_be.Product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductRepository repository;

    //상품 목록 전체 보여주기 (상품전체페이지)
    @GetMapping("/api/main/products")
    public ResponseDto<?> getAllProduct(HttpServletRequest request){
        return productService.getAllProduct(request);
    }


    //해당하는 제품 상세 페이지
    @GetMapping("/api/main/products/{product_id}")
    public ResponseDto<?> getOneProduct(@PathVariable Long product_id, HttpServletRequest request){
        return productService.getOneProduct(product_id, request);
    }

    @PostMapping("/api/post")
    public ResponseDto<?> post(@RequestBody ProductDto productDto){
        Product p = new Product(productDto);
        repository.save(p);
        return ResponseDto.success("물품 post 성공");
    }
}