package util.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Item;
import model.ItemList;
import model.Product;
import model.ProductList;

public class ItemUnmarshaller {
    public static void main(String[] args){
    	
		try {
			JAXBContext jc = JAXBContext.newInstance(ItemList.class);
		
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        ItemList items = (ItemList) unmarshaller.unmarshal(new File("XMLResources/Warehouse/WarehouseItemList.xml"));
	        
	        System.out.println(items.getItemList().size());
	        for (Item currentItem : items.getItemList())
	        {
	        	System.out.println(currentItem.getManufacturerName());
	        	System.out.println(currentItem.getProductType());
	        	System.out.println(currentItem.getUnitPrice());
	        	System.out.println(currentItem.getQuantity());
	        }
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
