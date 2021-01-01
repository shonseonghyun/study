package sql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements Dao {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Cart> viewAll() {
		return sqlSession.selectList("cart.viewAll");
	}

	@Override
	public void insert(Cart cart) {
		sqlSession.insert("cart.insert",cart);
	}

	@Override
	public Cart detail(String id) {
		return sqlSession.selectOne("cart.detail", id);
	}

	@Override
	public void update(Cart cart) {
		sqlSession.update("cart.update",cart);
	}

	@Override
	public boolean check(String id, int product_id) {
		boolean result=false;
//		System.out.println(id);
//		System.out.println(product_id);
		Map<String,Object> map=new HashMap<>();
		map.put("id", id);
		map.put("product_id", product_id);
		int cnt=sqlSession.selectOne("cart.check",map);
//		System.out.println(cnt);
		if(cnt==1) {
			result=true;
		}
		return result;
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("cart.delete", id);
	}

}
