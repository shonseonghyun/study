package model.shop.dao.admin;

import model.shop.dto.member.MemberDTO;
import model.shop.dto.product.ProductDTO;

public interface AdminDAO {
	public String login_check(MemberDTO admin);
	ProductDTO detailProduct(int product_id); //��ǰ �� ����
	void update(ProductDTO product);
	String file_name(int product_id);
}
