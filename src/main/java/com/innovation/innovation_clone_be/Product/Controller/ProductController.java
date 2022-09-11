package com.innovation.innovation_clone_be.Product.Controller;
import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import com.innovation.innovation_clone_be.Product.Dto.Request.ProductRequestDto;
import com.innovation.innovation_clone_be.Product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //상품 목록 전체 보여주기 (상품전체페이지)
    @GetMapping("/api/main/products")
    public ResponseDto<?> getAllProduct(){
        return productService.getAllProduct();
    }


    //해당하는 제품 상세 페이지
    @GetMapping("/api/main/products/{product_id}")
    public ResponseDto<?> getOneProduct(@PathVariable Long product_id){
        return productService.getOneProduct(product_id);
    }
}