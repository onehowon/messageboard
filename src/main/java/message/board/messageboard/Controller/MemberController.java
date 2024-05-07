package message.board.messageboard.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import message.board.messageboard.Dto.LoginDto;
import message.board.messageboard.entity.member.Member;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class MemberController {
    @GetMapping("/login")
    public String getLogin(HttpServletRequest request, Model model){

        // 현재 페이지를 가져와 세션에 저장
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("prevPage", referer);
        log.info("uri={}", referer);
        model.addAttribute("login", new LoginDto());
        return "member/login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("login") LoginDto loginDto, HttpServletRequest request, HttpSession session, Model model){
        boolean login = memberService.login(loginDto);

        if(login){
            String username = loginDto.getUsername();
            Member member = memberService.findByUsername(username);
            session.setAttribute("loginMember", Member);

            String prevPage = (String) request.getSession().getAttribute("prevPage");

        }

        model.addAttribute("error", "비밀번호 또는 아이디가 올바르지 않습니다.");
        return "member/login";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginMember");
        return "redirect:/";
    }
}
