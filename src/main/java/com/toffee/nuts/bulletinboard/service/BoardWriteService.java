package com.toffee.nuts.bulletinboard.service;


import com.toffee.nuts.bulletinboard.entity.Board;
import com.toffee.nuts.bulletinboard.entity.Member;
import com.toffee.nuts.bulletinboard.repository.BoardRepository;
import com.toffee.nuts.bulletinboard.util.BoardWriteRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardWriteService {
    private final MemberFindService memberFindService;
    private final BoardRepository boardRepository;

    @Transactional
    public Long writeBoard(Long userId, BoardWriteRequest boardWriteRequest) {
        Member member = memberFindService.findById(userId);

        Board board = Board.builder()
                .title(boardWriteRequest.getTitle())
                .writer(member.getUsername())
                .content(boardWriteRequest.getContent())
                .category(boardWriteRequest.getCategory())
                .build();

        Board savedBoard = boardRepository.save(board);
        member.writeBoard(savedBoard);
        return savedBoard.getBoard_id();

    }

}
