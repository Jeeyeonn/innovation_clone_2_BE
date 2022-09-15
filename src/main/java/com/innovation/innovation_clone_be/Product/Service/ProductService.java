package com.innovation.innovation_clone_be.Product.Service;

import com.innovation.innovation_clone_be.Cart.Entity.Cart;
import com.innovation.innovation_clone_be.Cart.Repository.CartRepository;
import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import com.innovation.innovation_clone_be.Error.Enum.ErrorCode;
import com.innovation.innovation_clone_be.Member.Entity.Member;
import com.innovation.innovation_clone_be.Member.Service.MemberService;
import com.innovation.innovation_clone_be.Product.Dto.Response.ProductDetailResponseDto;
import com.innovation.innovation_clone_be.Product.Dto.Response.ProductResponseDto;
import com.innovation.innovation_clone_be.Product.Entity.Product;
import com.innovation.innovation_clone_be.Product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final MemberService memberService;
    private final CartRepository cartRepository;

    @Transactional
    public ResponseDto<?> getAllProduct(HttpServletRequest request) {

        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for(Product product: products){
            productResponseDtos.add(ProductResponseDto.builder()
                    .productId(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .img1(product.getImg1())
                    .img2(product.getImg2()).build());
        }

        //로그인 토큰 유효성 검증하기
        ResponseDto<?> result = memberService.checkMember(request);
        Member member = (Member) result.getData();

        if (member == null){
            return ResponseDto.success(productResponseDtos);
        }else {
            List<Cart> carts = cartRepository.findCartByMember(member);
            return ResponseDto.success(productResponseDtos, carts.size());
        }
    }

    @Transactional
    public ResponseDto<?> getOneProduct(Long product_id, HttpServletRequest request) {

        Product product = productRepository.findProductById(product_id);

        //해당하는 제품 아이디 없을 시 오류 반환
        if(product == null)
            return ResponseDto.fail(ErrorCode.INVALID_PRODUCT);

        ProductDetailResponseDto productDetailResponseDto
                = ProductDetailResponseDto.builder()
                .productId(product_id)
                .name(product.getName())
                .content(product.getContent())
                .img1(product.getImg1())
                .price(product.getPrice()).build();

        //로그인 토큰 유효성 검증하기
        ResponseDto<?> result = memberService.checkMember(request);
        Member member = (Member) result.getData();

        if (member == null){
            return ResponseDto.success(productDetailResponseDto);
        }else {
            List<Cart> carts = cartRepository.findCartByMember(member);
            return ResponseDto.success(productDetailResponseDto, carts.size());
        }
    }
}