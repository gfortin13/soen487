package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Item")
public class Item {
	@XmlElement(name = "manufacturerName")
	private String manufacturerName;
	@XmlElement(name = "productType")
	private ProductType productType;
	@XmlElement(name = "unitPrice")
	private float unitPrice;
	@XmlElement(name = "quantity")
	private int quantity;
	
	public Item(String manufacturerName, ProductType productType, float unitPrice, int quantity){
		this.manufacturerName = manufacturerName;
		this.productType = productType;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	public Item(){
		
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
