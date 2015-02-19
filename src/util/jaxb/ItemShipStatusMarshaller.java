package util.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.Item;
import model.ItemList;
import model.ItemShippingStatus;
import model.ItemShippingStatusList;

public class ItemShipStatusMarshaller {
	public static void main(String[] args) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(ItemShippingStatusList.class);
		
		/*Unmarshaller unmarshaller = jc.createUnmarshaller();
		Cars cars = (Cars) unmarshaller.unmarshal(new File("cars.xml"));*/
		
		ItemShippingStatusList issl = new ItemShippingStatusList();
		
		Item item1 = new Item("Kobayashi", "TV", 1299.99f, 1);
		Item item2 = new Item("Kobayashi", "DVD Player", 129.99f, 3);
		Item item3 = new Item("Kobayashi", "Video Camera", 459.99f, 2);
		
		ItemShippingStatus iss1 = new ItemShippingStatus(item1, "Shipped");
		ItemShippingStatus iss2 = new ItemShippingStatus(item2, "Not Shipped");
		ItemShippingStatus iss3 = new ItemShippingStatus(item3, "Shipped");
		
		issl.add(iss1);
		issl.add(iss2);
		issl.add(iss3);
		
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(issl, System.out);
		marshaller.marshal(issl, new File("XMLResources/Warehouse/WarehouseShippingStatusList.xml"));
	}
}
