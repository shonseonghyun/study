package portfolio.service.member;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import portfolio.dto.member.MemberDTO;

public interface PfMemberService {
	String logincheck(MemberDTO member,HttpSession session);
	void logout(HttpSession session);
	int idcheck(String id);
	void sign(MemberDTO member);
	void keepLogin(String id,String sessionKey,Date next);
	MemberDTO checkUserwithSessionkey(String sessionKey);

}
