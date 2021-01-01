package model.shop.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.shop.dao.admin.AdminDAO;
import model.shop.dto.member.MemberDTO;
import model.shop.dto.product.ProductDTO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDao;
	
	@Override
	public String login_check(MemberDTO admin) {
		return adminDao.login_check(admin);
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		return adminDao.detailProduct(product_id);
	}

	@Override
	public void update(ProductDTO product) {
		adminDao.update(product);
	}

	@Override
	public String file_name(int product_id) {
		// TODO Auto-generated method stub
		return adminDao.file_name(product_id);
	}

}
