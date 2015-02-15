package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Product", propOrder={
		"ManufacturerName",
		"ProductType",
		"UnitPrice"
})
public class Product {
	@XmlElement(name = "ManufacturerName")
	private String ManufacturerName;
	@XmlElement(name = "ProductType")
	private String ProductType;
	@XmlElement(name = "UnitPrice")
	private float UnitPrice;
	
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

	public void setProductType(String productType) {
		this.ProductType = productType;
	}

	public String getManufacturerName() {
		return ManufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.ManufacturerName = manufacturerName;
	}
	
	public float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.UnitPrice = unitPrice;
	}
	
}
