package com.toffee.nuts.bulletinboard.service;

import com.toffee.nuts.bulletinboard.entity.Member;
//import com.toffee.nuts.bulletinboard.entity.MemberDetails;
import com.toffee.nuts.bulletinboard.entity.SecurityUser;
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
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member>  member = memberRepository.findByUsername(username);

        if (!member.isPresent()) throw new UsernameNotFoundException("존재하지 않는 username 입니다.");

        log.info("loadUserByUsername member.username = {}", username);

        return new SecurityUser(member.get());


    }
}
