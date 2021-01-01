package model.shop.dao.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.shop.dto.member.MemberDTO;
import model.shop.dto.product.ProductDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public String login_check(MemberDTO admin) {
		return sqlSession.selectOne("admin.login_check", admin);
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		return sqlSession.selectOne("admin.detail", product_id);
	}

	@Override
	public void update(ProductDTO product) {
		sqlSession.update("admin.modify", product);
	}

	@Override
	public String file_name(int product_id) {
		return sqlSession.selectOne("admin.file_name", product_id);
	}

}
