package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ItemList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemList extends ArrayList<Item>{
	@XmlElement(name = "Item")
	private List<Item> itemList;
	
	public ItemList(){
		itemList = new ArrayList<Item>();
	}
	
	public boolean add(Item i){
		itemList.add(i);
		return true;
	}
}
