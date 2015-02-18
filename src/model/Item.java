package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Item", namespace="http://www.example.org/soen487")
public class Item {
	
	private String manufacturerName;
	
	@XmlElement(name = "ManufacturerName")
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	
	private String productType;
	
	@XmlElement(name = "ProductType")
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	private float unitPrice;
	
	@XmlElement(name = "UnitPrice")
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	private int quantity;
	
	@XmlElement(name = "Quantity")
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Item(String manufacturerName, String productType, float unitPrice, int quantity){
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

	public String getProductType() {
		return productType;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public boolean equals (Object o){
		if(o instanceof Item){
			Item toCompare = (Item) o;
		    return (this.manufacturerName.equals(toCompare.manufacturerName) && this.productType.equals(toCompare.productType));
		  }
		  return false;
	}
}
