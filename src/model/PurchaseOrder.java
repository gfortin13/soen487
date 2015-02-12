package model;

public class PurchaseOrder {
	private String orderNum;
	private String customerRef;
	private Product product;
	private int quantity;
	private float unitPrice;
	
	public PurchaseOrder(String orderNum, String customerRef, Product product, int quantity, float unitPrice){
		this.orderNum = orderNum;
		this.customerRef = customerRef;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getCustomerRef() {
		return customerRef;
	}

	public void setCustomerRef(String customerRef) {
		this.customerRef = customerRef;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
}
