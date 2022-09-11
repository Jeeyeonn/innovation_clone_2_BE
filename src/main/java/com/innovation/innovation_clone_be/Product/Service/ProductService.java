package com.innovation.innovation_clone_be.Product.Service;

import com.innovation.innovation_clone_be.Cart.Entity.Cart;
import com.innovation.innovation_clone_be.Cart.Repository.CartRepository;
import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import com.innovation.innovation_clone_be.Error.Enum.ErrorCode;
import com.innovation.innovation_clone_be.Member.Entity.Member;
import com.innovation.innovation_clone_be.Member.Repository.MemberRepository;
import com.innovation.innovation_clone_be.Product.Dto.Request.ProductRequestDto;
import com.innovation.innovation_clone_be.Product.Dto.Response.ProductResponseDto;
import com.innovation.innovation_clone_be.Product.Entity.Product;
import com.innovation.innovation_clone_be.Product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;

    @Transactional
    public ResponseDto<?> getAllProduct() {

        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for(Product product: products){
            productResponseDtos.add(new ProductResponseDto(product));
        }

        return ResponseDto.success(productResponseDtos);
    }

    public ResponseDto<?> addCartProduct(ProductRequestDto requestDto) {

        //로그인 토큰 유효성 검증하기
        //Member member = memberRepository.findById();
        // 구현하기 ----------------------------------------------------------

        Product product = productRepository.findProductById(requestDto.getProductId());

        //해당하는 제품 ID가 없을 시 오류 코드 반환
        if (product == null)
            return ResponseDto.fail(ErrorCode.INVALID_PRODUCT);

//        Cart cart = new Cart(member, product);
//        cartRepository.save(cart);
//
//        member.getCarts().add(cart);

        //해당 제품의 장바구니 수도 업데이트
        product.setCartNum(product.getCarts().size());

        return ResponseDto.success("success post");

    }
}