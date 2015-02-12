package util.XMLUtils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Item;
import model.ItemList;
import model.Product;
import model.ProductType;

public class testjaxb {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Product.class);
        
       /* ItemList items = new ItemList();
        items.add(new Item("Kobayashi", ProductType.TV, 1200, 2));
        items.add(new Item("Kobayashi", ProductType.TV, 2200, 4));
        items.add(new Item("Kobayashi", ProductType.TV, 560, 6));
        items.add(new Item("Samsung", ProductType.VIDEOCAMERA, 1100, 1));
        items.add(new Item("Samsung", ProductType.VIDEOCAMERA, 1200, 7));
        items.add(new Item("Samsung", ProductType.VIDEOCAMERA, 400, 2));
        items.add(new Item("LG", ProductType.DVDPLAYER, 800, 7));
        items.add(new Item("LG", ProductType.DVDPLAYER, 700, 8));
        items.add(new Item("LG", ProductType.DVDPLAYER, 320, 3));*/
        
        
        Product product = new Product(ProductType.DVDPLAYER, "test", 6);

        //Unmarshaller unmarshaller = jc.createUnmarshaller();
        //Cars cars = (Cars) unmarshaller.unmarshal(new File("cars.xml"));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(product, System.out);
    }
}
