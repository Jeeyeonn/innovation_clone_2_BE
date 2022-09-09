package com.innovation.innovation_clone_be.Product.Entity;

import com.innovation.innovation_clone_be.Cart.Entity.Cart;
import com.innovation.innovation_clone_be.Product.Dto.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String img1;

    @Column(nullable = false)
    private String img2;

    @Column(nullable = false)
    private int cartNum;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts;

    public Product(ProductDto productDto){
        this.name = productDto.getName();
        this.content = productDto.getContent();;
        this.price = productDto.getPrice();
        this.img1 = productDto.getImg1();
        this.img2 = productDto.getImg2();
        this.cartNum = productDto.getCartNum();
    }
}
