package model.shop.service.product;

import java.util.List;

import model.shop.dto.product.ProductDTO;

public interface ProductSerivce {
	List<ProductDTO> listProduct(); //��ǰ ���
	ProductDTO detailProduct(int product_id); //��ǰ �� ����
	void updateProduct(ProductDTO product); //��ǰ ���� ����
	void deleteProduct(int product_id); //��ǰ ����
	void insertProduct(ProductDTO product); //��ǰ �߰�
	String fileInfo(int product_id);  //���� ����
}
