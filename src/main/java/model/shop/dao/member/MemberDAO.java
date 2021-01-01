package model.shop.dao.member;

import model.shop.dto.member.MemberDTO;

public interface MemberDAO {
	public String loginCheck(MemberDTO member);
}
