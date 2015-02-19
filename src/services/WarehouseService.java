package services;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Customer;
import model.Item;
import model.ItemList;
import model.ItemShippingStatus;
import model.ItemShippingStatusList;
import model.ProductList;

public class WarehouseService {

	// IMPORTANT: WRITE RELATIVE PATH ON OWN MACHINE
	private final String WAREHOUSEITEMSXMLPATH = "XMLResources/Warehouse/WarehouseItemList.xml";
	private final String ITEMSHIPPINGSTATUSXMLPATH = "XMLResources/Warehouse/WarehouseShippingStatusList.xml";
	private ItemList warehouseItems;
	private ItemShippingStatusList itemShippingStatusList;
	
	/*For each item in the itemList, check the inventory. Ship out the items that are available
	in the inventory to the Customer. You need to come up with a list of \shipped" items
	and \not shipped" items and make them as an ItemShippingStatusList and return it to
	the caller. You need to subtract the items shipped from the inventory. At the end of the
	operation, call the replenish() to replenish the inventory.*/
	public ItemShippingStatusList shipGoods(ItemList itemList, Customer info){
		
		//Create the shipping status list and ;load the xml info into a variable
		//ItemShippingStatusList statusList = new ItemShippingStatusList();
		loadItemShippingStatus();
		loadWarehouseItems();
		
		for (Item currentItem : itemList.getItemList())
		{
			//Create an item stub which will simply hold manufacturerName and productType, which
			//are the only pieces of information needed to compare equivalence
			Item itemInfo = new Item(currentItem.getManufacturerName(), currentItem.getProductType(), 0, 0);
			if (warehouseItems.getItemList().contains(itemInfo))
			{
				//if the item ordered exists within the xml file, save the full item info to a variable
				itemInfo = warehouseItems.getItemList().get(warehouseItems.getItemList().indexOf(itemInfo));
				
				if (itemInfo.getQuantity() >= currentItem.getQuantity())
				{
					//If the quantity on hand is greater than or equal to the amount ordered,
					//update the quantity and mark the item as shipped
					itemInfo.setQuantity(itemInfo.getQuantity() - currentItem.getQuantity());
					ItemShippingStatus itemStatus = new ItemShippingStatus(currentItem,  "shipped");
					itemShippingStatusList.add(itemStatus);
				}
				else
				{
					//If there aren't enough items in stock, mark the item as not shipped
					ItemShippingStatus itemStatus = new ItemShippingStatus(currentItem,  "not shipped");
					itemShippingStatusList.add(itemStatus);
				}
			}
			else
			{
				//If the item does not appear within the xml file, mark the item as not shipped
				ItemShippingStatus itemStatus = new ItemShippingStatus(currentItem,  "not shipped");
				itemShippingStatusList.add(itemStatus);
			}
		}
		
		//Call replenish and return the status list
		replenish();
		updateItemShippingStatus();
		return itemShippingStatusList;
	}
	
	public void shipGood(Item item, Customer info){
		
		//Create the shipping status list and ;load the xml info into a variable
		//ItemShippingStatusList statusList = new ItemShippingStatusList();
		loadItemShippingStatus();
		loadWarehouseItems();

		//Create an item stub which will simply hold manufacturerName and productType, which
		//are the only pieces of information needed to compare equivalence
		Item itemInfo = new Item(item.getManufacturerName(), item.getProductType(), 0, 0);
		if (warehouseItems.getItemList().contains(itemInfo))
		{
			//if the item ordered exists within the xml file, save the full item info to a variable
			itemInfo = warehouseItems.getItemList().get(warehouseItems.getItemList().indexOf(itemInfo));
			
			if (itemInfo.getQuantity() >= item.getQuantity())
			{
				//If the quantity on hand is greater than or equal to the amount ordered,
				//update the quantity and mark the item as shipped
				itemInfo.setQuantity(itemInfo.getQuantity() - item.getQuantity());
				ItemShippingStatus itemStatus = new ItemShippingStatus(item,  "shipped");
				itemShippingStatusList.add(itemStatus);
			}
			else
			{
				//If there aren't enough items in stock, mark the item as not shipped
				ItemShippingStatus itemStatus = new ItemShippingStatus(item,  "not shipped");
				itemShippingStatusList.add(itemStatus);
			}
		}
		else
		{
			//If the item does not appear within the xml file, mark the item as not shipped
			ItemShippingStatus itemStatus = new ItemShippingStatus(item,  "not shipped");
			itemShippingStatusList.add(itemStatus);
		}
	
		
		//Call replenish and return the status list
		replenish();
		updateItemShippingStatus();
		//return itemShippingStatusList;
	}
	
	
	/*This method can be called by shipGoods(). Check the inventory items. If the inven-
	tory of some items is lower than a threshold (defined by you), order the items from the
	Manufacturer. You can decide how many to order.*/
	private void replenish(){
		
		for (Item currentItem : warehouseItems.getItemList())
		{
			if (currentItem.getQuantity() < 10)
				currentItem.setQuantity(currentItem.getQuantity() + 10);
		}
		
		updateWarehouseItems();
	}
	
	
	/*
	 * This private method is used to load the Warehouse product information from xml into objects.
	 */
	private ItemList loadWarehouseItems(){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(ItemList.class);
			Unmarshaller itemListUnmarshaller = context.createUnmarshaller();
			warehouseItems = (ItemList)itemListUnmarshaller.unmarshal(new File(WAREHOUSEITEMSXMLPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return warehouseItems;
	}
	
	/*
	 * This private method is used to save the state of the Warehouse product information to xml.
	 */
	private void updateWarehouseItems(){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(ItemList.class);
			Marshaller itemListMarshaller = context.createMarshaller();
			itemListMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			itemListMarshaller.marshal(warehouseItems, new File(WAREHOUSEITEMSXMLPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * This private method is used to load the Item Shipping List information from xml into objects.
	 */
	private ItemShippingStatusList loadItemShippingStatus(){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(ItemShippingStatusList.class);
			Unmarshaller itemListUnmarshaller = context.createUnmarshaller();
			itemShippingStatusList = (ItemShippingStatusList)itemListUnmarshaller.unmarshal(new File(ITEMSHIPPINGSTATUSXMLPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return itemShippingStatusList;
	}
	
	/*
	 * This private method is used to save the state of the Item Shipping List information to xml.
	 */
	private void updateItemShippingStatus(){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(ItemShippingStatusList.class);
			Marshaller itemShippingListMarshaller = context.createMarshaller();
			itemShippingListMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			itemShippingListMarshaller.marshal(itemShippingStatusList, new File(ITEMSHIPPINGSTATUSXMLPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
