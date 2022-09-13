package com.innovation.innovation_clone_be.Member.Repository;

import com.innovation.innovation_clone_be.Member.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    Member findMemberByEmail(String email);
}
