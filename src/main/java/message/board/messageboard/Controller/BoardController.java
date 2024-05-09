package message.board.messageboard.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import message.board.messageboard.entity.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    @GetMapping("/board")
    public String board(Model model, HttpSession session){
        getSession(model, session);

        return "board/board";
    }

    private static void getSession(Model model, HttpSession session){
        Member loginMember = (Member) session.getAttribute("loginMember");
        model.addAttribute("loginMember", loginMember);
    }
}
