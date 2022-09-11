package com.innovation.innovation_clone_be.Cart.Repository;

import com.innovation.innovation_clone_be.Cart.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
