package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemList{
	
	@XmlElement(name = "item")
	private List<Item> ItemList;
	
	public ItemList(){
		ItemList = new ArrayList<Item>();
	}
	
	public List<Item> getItemList() {
		return ItemList;
	}

	public void setItemList(List<Item> itemList) {
		ItemList = itemList;
	}

	public boolean add(Item i){
		return ItemList.add(i);
	}
}
