package message.board.messageboard.service;

import message.board.messageboard.Dto.MemberDto;

public interface MemberService {

    Member saveEntity(Member member);

    Member saveDto(MemberDto memberDto);
}
