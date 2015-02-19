package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "itemShippingStatus")
public class ItemShippingStatus {
	
	private Item item;
	private String status;
	
	public ItemShippingStatus(Item item, String status) {
		this.item = item;
		this.status = status;
	}
	
	public ItemShippingStatus() {
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
