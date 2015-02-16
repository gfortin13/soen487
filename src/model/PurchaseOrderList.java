package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PurchaseOrders")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseOrderList extends ArrayList<PurchaseOrder>{
	
	private List PurchaseOrderList;
	
	@XmlElement(name = "PurchaseOrder")
	public void setPurchaseOrderList(List PurchaseOrderList){
		this.PurchaseOrderList = PurchaseOrderList;
	}
	
	
	public PurchaseOrderList(){
		PurchaseOrderList = new ArrayList<PurchaseOrder>();
	}
	
	
	
	public boolean add(PurchaseOrder p){
		PurchaseOrderList.add(p);
		return true;
	}
}