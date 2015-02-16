package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PurchaseOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseOrder {
	
	private String OrderNum;
	@XmlElement(name = "OrderNum")
	public void setOrderNum(String OrderNum) {
		this.OrderNum = OrderNum;
	}
	
	private String CustomerRef;
	@XmlElement(name = "CustomerRef")
	public void setCustomerRef(String CustomerRef) {
		this.CustomerRef = CustomerRef;
	}
	
	private Product Product;
	@XmlElement(name = "Product")
	public void setProduct(Product Product) {
		this.Product = Product;
	}
	
	private int Quantity;
	@XmlElement(name = "Quantity")
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}
	
	private float UnitPrice;
	@XmlElement(name = "UnitPrice")
	public void setUnitPrice(float UnitPrice) {
		this.UnitPrice = UnitPrice;
	}
	
	private String PaymentStatus;
	@XmlElement(name = "PaymentStatus")
	public void setPaymentStatus(String PaymentStatus) {
		this.PaymentStatus = PaymentStatus;
	}
	
	public PurchaseOrder(String orderNum, String customerRef, Product product, int quantity, float unitPrice, String paymentStatus){
		this.OrderNum = orderNum;
		this.CustomerRef = customerRef;
		this.Product = product;
		this.Quantity = quantity;
		this.UnitPrice = unitPrice;
		this.PaymentStatus = paymentStatus;
	}

	public String getOrderNum() {
		return OrderNum;
	}

	public String getCustomerRef() {
		return CustomerRef;
	}

	public Product getProduct() {
		return Product;
	}

	public int getQuantity() {
		return Quantity;
	}

	public float getUnitPrice() {
		return UnitPrice;
	}
	
	public String getPaymentStatus() {
		return PaymentStatus;
	}
}
