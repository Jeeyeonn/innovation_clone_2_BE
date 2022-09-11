package com.innovation.innovation_clone_be.Cart.Service;

import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import com.innovation.innovation_clone_be.Error.Enum.ErrorCode;
import com.innovation.innovation_clone_be.Product.Dto.Request.ProductRequestDto;
import com.innovation.innovation_clone_be.Product.Entity.Product;
import com.innovation.innovation_clone_be.Product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductRepository productRepository;

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
