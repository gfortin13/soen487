package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "purchaseOrders")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseOrderList {
	
	@XmlElement(name = "purchaseOrder")
	private List<PurchaseOrder> purchaseOrderList;
	
	public PurchaseOrderList(){
		purchaseOrderList = new ArrayList<PurchaseOrder>();
	}
	
	public List<PurchaseOrder> getPurchaseOrderList() {
		return purchaseOrderList;
	}

	public void setPurchaseOrderList(List<PurchaseOrder> purchaseOrderList) {
		this.purchaseOrderList = purchaseOrderList;
	}

	public boolean add(PurchaseOrder p){
		purchaseOrderList.add(p);
		return true;
	}
}