package portfolio.dao.member;

import java.sql.Date;

import portfolio.dto.member.MemberDTO;

public interface PfMemberDAO {
	String logincheck(MemberDTO member);
	int idcheck(String id);
	void sign(MemberDTO member);
	void keepLogin(String id,String sessionKey,Date next);
	MemberDTO checkUserwithSessionkey(String sessionKey);
}
