package com.toffee.nuts.bulletinboard.service;

import com.toffee.nuts.bulletinboard.entity.Member;
import com.toffee.nuts.bulletinboard.repository.MemberRepository;
import com.toffee.nuts.bulletinboard.util.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberFindService {
    private final MemberRepository memberRepository;


    @Transactional(readOnly = true)
    public Member findById(Long id) {
        return memberRepository.findById(id).
                orElseThrow(() -> new NotFoundUserException(String.format("There is no Id : %s", id)));
    }

}
