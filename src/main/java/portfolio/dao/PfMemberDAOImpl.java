package portfolio.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import portfolio.dto.member.MemberDTO;

@Repository
public class PfMemberDAOImpl implements PfMemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	//�α���
	@Override
	public String logincheck(MemberDTO member) {
		String name=sqlSession.selectOne("pfmember.logincheck",member);
		return name;
	}

	//���̵� �ߺ�üũ
	@Override
	public int idcheck(String id) {
		return sqlSession.selectOne("pfmember.idcheck", id);
	}

	@Override
	public void sign(MemberDTO member) {
		sqlSession.insert("pfmember.sign", member);
	}

}
