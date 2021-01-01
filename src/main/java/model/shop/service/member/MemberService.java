package model.shop.service.member;

import javax.servlet.http.HttpSession;

import model.shop.dto.member.MemberDTO;

public interface MemberService {
	public String loginCheck(MemberDTO member,HttpSession session);
	public void logout(HttpSession session);
}
