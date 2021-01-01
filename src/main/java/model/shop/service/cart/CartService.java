package model.shop.service.cart;

import java.util.List;

import model.shop.dto.cart.CartDTO;

public interface CartService {
	List<CartDTO> cartMoney(); //
	void insert(CartDTO cart); //��ٱ��� �߰�
	List<CartDTO> listCart(String id); //����� ���̵� ���� �� ��ٱ��� ���
	void del(int cart_id);
	void delall(String id);
	public void modify(int cart_id,int amount);
}
