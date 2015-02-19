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
	
	private List<Item> ItemList;
	
	@XmlElement(name = "item")
	public void setItemList(List<Item> ItemList){
		this.ItemList = ItemList;
	}
	
	public List<Item> getItemList(){
		return ItemList;
	}
	
	public ItemList(){
		ItemList = new ArrayList<Item>();
	}
	
	public boolean add(Item i){
		return ItemList.add(i);
	}
}
