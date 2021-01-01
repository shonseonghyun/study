package model.shop.dao.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.shop.dto.cart.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<CartDTO> cartMoney() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CartDTO cart) {
		sqlSession.insert("cart.insert",cart);
		
	}

	@Override
	public List<CartDTO> listCart(String id) {
		return sqlSession.selectList("cart.listCart", id);
	}


	@Override
	public void del( int cart_id) {
		sqlSession.delete("cart.del", cart_id);
	}

	@Override
	public void delall(String id) {
		sqlSession.delete("cart.delall", id);
	}

	@Override
	public void modify(int cart_id, int amount) {
		System.out.println("DAO µé¾î¿È");

		Map<String,Integer> map=new HashMap<>();
		map.put("cart_id", cart_id);
		map.put("amount", amount);
		sqlSession.update("cart.modify", map);
	}
	

}
