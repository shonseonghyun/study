package model.shop.service.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.shop.dao.cart.CartDAO;
import model.shop.dto.cart.CartDTO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDAO cartDao;
	
	@Override
	public List<CartDTO> cartMoney() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CartDTO cart) {
		cartDao.insert(cart);
	}

	@Override
	public List<CartDTO> listCart(String id) {
		return cartDao.listCart(id);
	}

	public void del(int cart_id) {
		cartDao.del(cart_id);
	}

	@Override
	public void delall(String id) {
		cartDao.delall(id);
	}

	@Override
	public void modify(int cart_id, int amount) {
		System.out.println("service µé¾î¿È");
		cartDao.modify(cart_id, amount);
	}
	
		


}
