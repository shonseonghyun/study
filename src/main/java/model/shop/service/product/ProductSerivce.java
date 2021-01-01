package model.shop.service.product;

import java.util.List;

import model.shop.dto.product.ProductDTO;

public interface ProductSerivce {
	List<ProductDTO> listProduct(); //상품 목록
	ProductDTO detailProduct(int product_id); //상품 상세 정보
	void updateProduct(ProductDTO product); //상품 정보 수정
	void deleteProduct(int product_id); //상품 삭제
	void insertProduct(ProductDTO product); //상품 추가
	String fileInfo(int product_id);  //파일 정보
}
