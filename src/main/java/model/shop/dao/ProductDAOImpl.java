package model.shop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.shop.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Override
	public List<ProductDTO> listProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(ProductDTO product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int product_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertProduct(ProductDTO product) {
		// TODO Auto-generated method stub

	}

	@Override
	public String fileInfo(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
