package model.shop.dto.cart;

public  class CartDTO {
	private String name;
	private String id;
	private int cart_id;
	private int product_id;
	private String product_name;
	private int price;
	private int amount;
	private int money;
	
	public CartDTO() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getMoney() {
		return money;
	}
	@Override
	public String toString() {
		return "CartDTO [name=" + name + ", id=" + id + ", product_id=" + product_id + ", product_name=" + product_name
				+ ", price=" + price + ", amount=" + amount + ", money=" + money + "]";
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	

}
