package portfolio.dao.member;

import portfolio.dto.member.MemberDTO;

public interface PfMemberDAO {
	String logincheck(MemberDTO member);
	int idcheck(String id);
	void sign(MemberDTO member);

}
