package com.example.web03.cart.model.dto;

public class CartVo {
	private int cart_id;
	private String userid;
	private String username;
	private int product_id;
	private String product_name;
	private int price;
	private int money;
	private int amount;
	
	
	public CartVo() {
		// TODO Auto-generated constructor stub
	}


	public CartVo(int cart_id, String userid, String username, int product_id,
			String product_name, int price, int money, int amount) {
		super();
		this.cart_id = cart_id;
		this.userid = userid;
		this.username = username;
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.money = money;
		this.amount = amount;
	}


	public int getCart_id() {
		return cart_id;
	}


	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "CartVo [cart_id=" + cart_id + ", userid=" + userid
				+ ", username=" + username + ", product_id=" + product_id
				+ ", product_name=" + product_name + ", price=" + price
				+ ", money=" + money + ", amount=" + amount + "]";
	}

}
