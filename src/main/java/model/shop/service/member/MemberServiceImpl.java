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
	
	//����ڰ� id,pwd�� ģ��
	@Override
	public String loginCheck(MemberDTO member, HttpSession session) {
		//������ �̸��� �Ѿ���� Ʋ���� null�� �Ѿ��
		String name=memberDao.loginCheck(member);
		if(name!=null) {
			session.setAttribute("id", member.getId());
			session.setAttribute("name",name);
		}
		return name;
	} 

	//�α׾ƿ�
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
}
