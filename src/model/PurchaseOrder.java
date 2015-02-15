package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PurchaseOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseOrder {
	@XmlElement(name = "OrderNum")
	private String orderNum;
	@XmlElement(name = "CustomerRef")
	private String customerRef;
	@XmlElement(name = "Product")
	private Product product;
	@XmlElement(name = "Quantity")
	private int quantity;
	@XmlElement(name = "UnitPrice")
	private float unitPrice;
	@XmlElement(name = "PaymentStatus")
	private String paymentStatus;
	
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
