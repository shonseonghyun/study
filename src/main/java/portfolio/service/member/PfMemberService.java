package portfolio.service.member;

import javax.servlet.http.HttpSession;

import portfolio.dto.member.MemberDTO;

public interface PfMemberService {
	String logincheck(MemberDTO member,HttpSession session);
	void logout(HttpSession session);
	int idcheck(String id);
	void sign(MemberDTO member);
}
