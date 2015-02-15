package model;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ProductList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductList extends ArrayList<Product>{

	private List<Product> ProductList;
	
	public ProductList(){
		ProductList = new ArrayList<Product>();
	}
	
	public boolean add(Product p){
		ProductList.add(p);
		return true;
	}
}