package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={
		"ManufacturerName",
		"ProductType",
		"UnitPrice"
})
public class Product {
	
	private String ManufacturerName;
	
	@XmlElement(name = "ManufacturerName")
	public void setManufacturerName(String manufacturerName) {
		this.ManufacturerName = manufacturerName;
	}
	
	private String ProductType;
	
	@XmlElement(name = "ProductType")
	public void setProductType(String productType) {
		this.ProductType = productType;
	}
	
	private float UnitPrice;
	
	@XmlElement(name = "UnitPrice")
	public void setUnitPrice(float unitPrice) {
		this.UnitPrice = unitPrice;
	}
	
	public Product(String productType, String manufacturerName, float unitPrice){
		this.ProductType = productType;
		this.ManufacturerName = manufacturerName;
		this.UnitPrice = unitPrice;
	}
	
	public Product(){
	}

	public String getProductType() {
		return ProductType;
	}

	public String getManufacturerName() {
		return ManufacturerName;
	}
	
	public float getUnitPrice() {
		return UnitPrice;
	}
	
}
