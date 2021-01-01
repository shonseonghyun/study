package model.shop.service.cart;

import java.util.List;

import model.shop.dto.cart.CartDTO;

public interface CartService {
	List<CartDTO> cartMoney(); //
	void insert(CartDTO cart); //장바구니 추가
	List<CartDTO> listCart(String id); //사용자 아이디 있을 시 장바구니 목록
	void del(int cart_id);
	void delall(String id);
	public void modify(int cart_id,int amount);
}
