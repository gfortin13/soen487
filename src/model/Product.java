package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	@XmlElement(name = "ProductType")
	private String productType;
	@XmlElement(name = "ManufacturerName")
	private String manufacturerName;
	@XmlElement(name = "UnitPrice")
	private float unitPrice;
	
	public Product(String productType, String manufacturerName, float unitPrice){
		this.productType = productType;
		this.manufacturerName = manufacturerName;
		this.unitPrice = unitPrice;
	}
	
	public Product(){
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	
	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
