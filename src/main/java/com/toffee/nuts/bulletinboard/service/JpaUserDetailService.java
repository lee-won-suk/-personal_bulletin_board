package com.toffee.nuts.bulletinboard.service;

import com.toffee.nuts.bulletinboard.entity.Member;
//import com.toffee.nuts.bulletinboard.entity.MemberDetails;
import com.toffee.nuts.bulletinboard.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 *
 * loginProcessiongUrl 주소로 들어오면 UserDetailsService 구현 클래스내 loadUserByUsername이 진행.
 */

@Slf4j
@Service
public class JpaUserDetailService implements UserDetailsService {


    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByUsername(username);


        log.info("loadUserByUsername member.username = {}", username);

        return new CustomUserDetails(member);


    }
}
