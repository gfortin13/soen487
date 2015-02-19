package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "itemShippingStatuses")
public class ItemShippingStatusList{

	@XmlElement(name = "itemShippingStatus")
	private List<ItemShippingStatus> itemShippingStatusList;

	public ItemShippingStatusList() {
		itemShippingStatusList = new ArrayList<ItemShippingStatus>();
	}

	public List<ItemShippingStatus> getItemShippingStatusList() {
		return itemShippingStatusList;
	}

	public void setItemShippingStatusList(
			List<ItemShippingStatus> itemShippingStatusList) {
		this.itemShippingStatusList = itemShippingStatusList;
	}
	
	public boolean add(ItemShippingStatus i){
		return itemShippingStatusList.add(i);
	}

}
