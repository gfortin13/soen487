package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PurchaseOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseOrder {
	
	private String orderNum;	
	private String customerRef;
	private Product product;
	private int quantity;
	private float unitPrice;
	private String paymentStatus;

	public PurchaseOrder(){
		
	}
	
	public PurchaseOrder(String orderNum, String customerRef, Product product, int quantity, float unitPrice, String paymentStatus){
		this.orderNum = orderNum;
		this.customerRef = customerRef;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.paymentStatus = paymentStatus;
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


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
