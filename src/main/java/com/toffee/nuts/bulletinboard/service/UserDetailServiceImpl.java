package com.toffee.nuts.bulletinboard.service;

import com.toffee.nuts.bulletinboard.entity.MemberDetails;
import com.toffee.nuts.bulletinboard.entity.User;
import com.toffee.nuts.bulletinboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 *
 * loginProcessiongUrl 주소로 들어오면 UserDetailsService 구현 클래스내 loadUserByUsername이 진행.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = userRepository.findByName(name);


        return new MemberDetails(user);
    }
}
