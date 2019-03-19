package com.cart.service.bean;

public class Product {
	private long id;
	private String name;
	private double basePrice;
	private int quantity;
	private double totlalPrice;

	public double getBasePrice() {
		return basePrice;
	}
	
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public Product(long id, String name, double basePrice, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.basePrice = basePrice;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotlalPrice() {
		return totlalPrice;
	}

	public void setTotlalPrice(double totlalPrice) {
		this.totlalPrice = totlalPrice;
	}

}
