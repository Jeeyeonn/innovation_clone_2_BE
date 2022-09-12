package com.innovation.innovation_clone_be.Cart.Service;

import com.innovation.innovation_clone_be.Cart.Dto.CartRequestDto;
import com.innovation.innovation_clone_be.Cart.Dto.CartResponseDto;
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

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;

    @Transactional
    public ResponseDto<?> addCartProduct(ProductRequestDto requestDto, HttpServletRequest request) {

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
//        product.getCarts().add(cart);

        //해당 제품의 장바구니 수도 업데이트
        product.setCartNum(product.getCarts().size());


        return ResponseDto.success("success post");

    }

    @Transactional
    public ResponseDto<?> addCartDetailProduct(Long product_id, CartRequestDto requestDto) {

        //로그인 토큰 유효성 검증하기
//        Member member = memberRepository.findById();
        // 구현하기 ----------------------------------------------------------

        Product product = productRepository.findProductById(product_id);

        //해당하는 제품 ID가 없을 시 오류 코드 반환
        if (product == null)
            return ResponseDto.fail(ErrorCode.INVALID_PRODUCT);

//        Cart cart = new Cart(product, requestDto, member);
//        cartRepository.save(cart);

//        member.getCarts().add(cart);
//        product.getCarts().add(cart);


        //해당 제품의 장바구니 수도 업데이트
        product.setCartNum(product.getCarts().size());

        return ResponseDto.success("success post");
    }

    @Transactional
    public ResponseDto<?> getMyCart() {
        //로그인 토큰 유효성 검증하기
//        Member member = memberRepository.findById();
        // 구현하기 ----------------------------------------------------------

        List<CartResponseDto> responseDtoList = new ArrayList<>();
//        List<Cart> carts = member.getCarts();
//
//        for (Cart cart : carts){
//            responseDtoList.add(new CartResponseDto(cart));
//        }

        return ResponseDto.success(responseDtoList);
    }

    @Transactional
    public ResponseDto<?> deleteCart(Long product_id) {
        //로그인 토큰 유효성 검증하기
        //Member member = memberRepository.findById();
        // 구현하기 ----------------------------------------------------------

        Product product = productRepository.findProductById(product_id);

        //해당하는 제품 ID가 없을 시 오류 코드 반환
        if (product == null)
            return ResponseDto.fail(ErrorCode.INVALID_PRODUCT);

//        Cart cart = cartRepository.findCartByMemberAndProduct(member, product);
//
//        //해당하는 제품이 해당 유저 장바구니에 없을 시 오류 코드 반환
//        if (cart == null)
//            return ResponseDto.fail(ErrorCode.INVALID_CART);
//
//        cartRepository.delete(cart);
        return ResponseDto.success("success delete");
    }

    public ResponseDto<?> getAllCart() {
        List<Product> cartList = productRepository.findAllByOrderByCartNumDesc();
        List<ProductResponseDto> cartResponseDto = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cartResponseDto.add(
            ProductResponseDto.builder()
                    .productId(cartList.get(i).getId())
                    .name(cartList.get(i).getName())
                    .price(cartList.get(i).getPrice())
                    .img1(cartList.get(i).getImg1())
                    .img2(cartList.get(i).getImg2())
                    .build()
            );

        }
        return ResponseDto.success(cartResponseDto);
    }



}
