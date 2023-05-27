package com.toffee.nuts.bulletinboard.repository;

import com.toffee.nuts.bulletinboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;




@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

   Member findByUsername(String username);

   Optional<Member> findByAccount(String account);
}