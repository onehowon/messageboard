package message.board.messageboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
}
