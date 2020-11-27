package model.shop.dao;

import java.util.List;

import model.shop.dto.ProductDTO;

public interface ProductDAO {
	
	List<ProductDTO> listProduct(); //��ǰ ���
	ProductDTO detailProduct(int product_id); //��ǰ �� ����
	void updateProduct(ProductDTO product); //��ǰ ���� ����
	void deleteProduct(int product_id); //��ǰ ����
	void insertProduct(ProductDTO product); //��ǰ �߰�
	String fileInfo(int product_id);  //���� ����
}
