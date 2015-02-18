package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ItemList", namespace="http://www.example.org/soen487")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemList extends ArrayList<Item>{
	
	private List ItemList;
	@XmlElement(name = "Item", type = Item.class)
	public void setItemList(List ItemList){
		this.ItemList = ItemList;
	}
	
	public List<Item> getItemList(){
		return ItemList;
	}
	
	public ItemList(){
		ItemList = new ArrayList<Item>();
	}
	
	public boolean add(Item i){
		ItemList.add(i);
		return true;
	}
}
