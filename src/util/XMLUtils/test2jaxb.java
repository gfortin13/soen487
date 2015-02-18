package util.XMLUtils;



import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Item;
import model.ItemList;
import model.Product;
import model.ProductList;

public class test2jaxb {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(ItemList.class);

        /*Unmarshaller unmarshaller = jc.createUnmarshaller();
        Cars cars = (Cars) unmarshaller.unmarshal(new File("cars.xml"));*/
        
        ItemList items = new ItemList();
        
        Item item = new Item("LG", "TV", 60, 5);
        
        items.add(item);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(items, System.out);
    }
}
