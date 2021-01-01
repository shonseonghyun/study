package model.shop.service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.shop.dao.member.MemberDAO;
import model.shop.dto.member.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {	
	
	@Autowired
	MemberDAO memberDao;
	
	//사용자가 id,pwd를 친다
	@Override
	public String loginCheck(MemberDTO member, HttpSession session) {
		//맞으면 이름이 넘어오고 틀리면 null이 넘어옴
		String name=memberDao.loginCheck(member);
		if(name!=null) {
			session.setAttribute("id", member.getId());
			session.setAttribute("name",name);
		}
		return name;
	} 

	//로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
}
