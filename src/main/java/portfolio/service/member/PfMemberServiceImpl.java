package portfolio.service.member;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portfolio.dao.member.PfMemberDAO;
import portfolio.dto.member.MemberDTO;

@Service
public class PfMemberServiceImpl implements PfMemberService {

	@Autowired
	PfMemberDAO memberdao;
	

	@Override
	public String logincheck(MemberDTO member, HttpSession session) {
		String name=memberdao.logincheck(member); //null이거나 name이거나
		if(name!=null) {
			session.setAttribute("id",member.getId());
			session.setAttribute("name",name);
		}
		return name;
	}


	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}


	@Override
	public int idcheck(String id) {
		
		return memberdao.idcheck(id);
	}


	@Override
	public void sign(MemberDTO member) {
		memberdao.sign(member);
	}


	@Override
	public void keepLogin(String id, String sessionKey, Date next) {
		memberdao.keepLogin(id, sessionKey, next);
	}


	@Override
	public MemberDTO checkUserwithSessionkey(String sessionKey) {
		return memberdao.checkUserwithSessionkey(sessionKey);
	}
}
