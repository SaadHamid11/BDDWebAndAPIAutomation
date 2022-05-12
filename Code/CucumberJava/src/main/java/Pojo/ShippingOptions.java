package Pojo;

public class ShippingOptions {
	
	private int Type;
	private double Price;
	private String Method;
	private int ShippingId;
	
	
	
	public ShippingOptions(int type, double price, String method, int shippingId) {
		this.Type = type;
		this.Price = price;
		this.Method = method;
		this.ShippingId = shippingId;
	}



	public int getType() {
		return Type;
	}



	public double getPrice() {
		return Price;
	}



	public String getMethod() {
		return Method;
	}



	public int getShippingId() {
		return ShippingId;
	}


	
	

}
