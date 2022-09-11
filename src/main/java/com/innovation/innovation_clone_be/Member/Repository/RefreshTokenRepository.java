package com.innovation.innovation_clone_be.Member.Repository;

import com.innovation.innovation_clone_be.Member.Entity.Member;
import com.innovation.innovation_clone_be.Member.Entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByMember(Member member);
}
