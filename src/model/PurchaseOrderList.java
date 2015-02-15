package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PurchaseOrderList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseOrderList extends ArrayList<PurchaseOrder>{
	
	@XmlElement(name = "PurchaseOrder")
	private List<PurchaseOrder> purchaseOrderList;
	
	public PurchaseOrderList(){
		purchaseOrderList = new ArrayList<PurchaseOrder>();
	}
	
	public boolean add(PurchaseOrder p){
		purchaseOrderList.add(p);
		return true;
	}
}