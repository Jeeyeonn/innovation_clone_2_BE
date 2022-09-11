package com.innovation.innovation_clone_be.Cart.Repository;

import com.innovation.innovation_clone_be.Cart.Entity.Cart;
import com.innovation.innovation_clone_be.Member.Entity.Member;
import com.innovation.innovation_clone_be.Product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findCartByMemberAndProduct(Member member, Product product);
}
