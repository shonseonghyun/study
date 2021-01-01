package sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CartService {
	
	@Autowired
	Dao dao;
	
	public List<Cart> viewAll() {
		return dao.viewAll();
	}
	
	public void insert(Cart cart) {
		dao.insert(cart);
	}
	public Cart detail(String id) {
		return dao.detail(id);
	}
	
	public void update(Cart cart) {
		dao.update(cart);
	}
	
	public boolean check(String id,int product_id) {
		return dao.check(id, product_id);
	}
	
	public void delete(String id) {
		dao.delete(id);
	}

}
