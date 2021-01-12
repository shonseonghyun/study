package portfolio.dao.member;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import portfolio.dto.member.MemberDTO;

@Repository
public class PfMemberDAOImpl implements PfMemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	//로그인
	@Override
	public String logincheck(MemberDTO member) {
		String name=sqlSession.selectOne("pfmember.logincheck",member);
		return name;
	}

	//아이디 중복체크
	@Override
	public int idcheck(String id) {
		return sqlSession.selectOne("pfmember.idcheck", id);
	}

	@Override
	public void sign(MemberDTO member) {
		sqlSession.insert("pfmember.sign", member);
	}

	//자동로그인
	@Override
	public void keepLogin(String id, String sessionKey, Date next) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("id", id);
		map.put("sessionKey", sessionKey);
		map.put("next", next);
		sqlSession.update("pfmember.keepLogin",map);
	}

	@Override
	public MemberDTO checkUserwithSessionkey(String sessionKey) {
		return sqlSession.selectOne("pfmember.checkUserwithSessionkey", sessionKey);
	}

}
