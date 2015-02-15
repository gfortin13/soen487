package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Item")
public class Item {
	@XmlElement(name = "ManufacturerName")
	private String manufacturerName;
	@XmlElement(name = "ProductType")
	private String productType;
	@XmlElement(name = "UnitPrice")
	private float unitPrice;
	@XmlElement(name = "Quantity")
	private int quantity;
	
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

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
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
	
	public boolean equals (Object o){
		if(o instanceof Item){
			Item toCompare = (Item) o;
		    return (this.manufacturerName.equals(toCompare.manufacturerName) && this.productType.equals(toCompare.productType));
		  }
		  return false;
	}
}
