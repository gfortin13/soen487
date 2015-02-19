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

public class ProductMarshaller {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(ProductList.class);

        /*Unmarshaller unmarshaller = jc.createUnmarshaller();
        Cars cars = (Cars) unmarshaller.unmarshal(new File("cars.xml"));*/
        
        ProductList products = new ProductList();
        
        Product prod = new Product("Kobayashi", "TV", 999.99f);
        Product prod2 = new Product("Kobayashi", "DVD Player", 99.99f);
        Product prod3 = new Product("Kobayashi", "Video Camera", 399.99f);
        
        products.add(prod);
        products.add(prod2);
        products.add(prod3);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(products, System.out);
        marshaller.marshal(products, new File("XMLResources/KobayashiManufacturer/KobayashiProducts.xml"));
    }
}
