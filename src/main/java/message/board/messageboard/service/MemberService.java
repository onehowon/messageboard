package message.board.messageboard.service;

import message.board.messageboard.Dto.MemberDto;
import message.board.messageboard.entity.member.Member;

public interface MemberService{

    Member saveEntity(Member member);

    Member saveDto(MemberDto memberDto);
}
