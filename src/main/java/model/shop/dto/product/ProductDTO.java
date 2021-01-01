package model.shop.dto.product;

public class ProductDTO {
	private int product_id;
	private String product_name;
	private double price;
	private String description;
	private String 	picture_url;
	
	public ProductDTO() {
		
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getPicture_url() {
		return picture_url;
	}

	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}

	public ProductDTO(int product_id, String product_name, double price, String description, String picture_url) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.description = description;
		this.picture_url = picture_url;
	}

	@Override
	public String toString() {
		return "ProductDTO [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", description=" + description + ", picture_url=" + picture_url + "]";
	}


	

	
	
}
