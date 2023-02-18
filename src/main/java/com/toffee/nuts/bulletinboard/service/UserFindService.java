package com.toffee.nuts.bulletinboard.service;

import com.toffee.nuts.bulletinboard.entity.User;
import com.toffee.nuts.bulletinboard.repository.UserRepository;
import com.toffee.nuts.bulletinboard.util.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserFindService {
    private final UserRepository userRepository;


    @Transactional(readOnly = true)
    public User findById(Long userId) {
        return userRepository.findById(userId).
                orElseThrow(() -> new NotFoundUserException(String.format("There is no Id : %s", userId)));
    }

}
