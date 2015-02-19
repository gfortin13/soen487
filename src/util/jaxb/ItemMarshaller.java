package util.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.Item;
import model.ItemList;
import model.Product;
import model.ProductList;

public class ItemMarshaller {
	public static void main(String[] args) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(ItemList.class);
		
		/*Unmarshaller unmarshaller = jc.createUnmarshaller();
		Cars cars = (Cars) unmarshaller.unmarshal(new File("cars.xml"));*/
		
		ItemList items = new ItemList();
		
		Item item1 = new Item("Kobayashi", "TV", 1299.99f, 4);
		Item item2 = new Item("Kobayashi", "DVD Player", 129.99f, 9);
		Item item3 = new Item("Kobayashi", "Video Camera", 459.99f, 8);
		
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(items, System.out);
		marshaller.marshal(items, new File("XMLResources/Warehouse/WarehouseItemList.xml"));
	}
}
