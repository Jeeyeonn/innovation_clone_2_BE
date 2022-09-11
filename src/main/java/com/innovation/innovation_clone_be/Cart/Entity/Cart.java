package com.innovation.innovation_clone_be.Cart.Entity;

import com.innovation.innovation_clone_be.Cart.Dto.CartRequestDto;
import com.innovation.innovation_clone_be.Member.Entity.Member;
import com.innovation.innovation_clone_be.Product.Entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean pack;

    @Column(nullable = false)
    private int count;

    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn(name = "product_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public Cart(Product product, CartRequestDto requestDto, Member member) {
        this.product = product;
        this.pack = requestDto.getPack();
        this.count = requestDto.getCount();
        this.member = member;
    }
}
