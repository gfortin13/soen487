package model;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductList {
	
	@XmlElement(name= "product" )
	private List<Product> productList;
	
	public ProductList(){
		productList = new ArrayList<Product>();
	}
	
	public void setProductList(List<Product> ProductList){
		this.productList = ProductList;
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public boolean add(Product p){
		productList.add(p);
		return true;
	}
}