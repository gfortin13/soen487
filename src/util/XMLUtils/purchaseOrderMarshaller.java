package util.XMLUtils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.Product;
import model.ProductList;
import model.PurchaseOrder;
import model.PurchaseOrderList;

public class purchaseOrderMarshaller {
	public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(PurchaseOrderList.class);

        /*Unmarshaller unmarshaller = jc.createUnmarshaller();
        Cars cars = (Cars) unmarshaller.unmarshal(new File("cars.xml"));*/
        
        PurchaseOrderList pol = new PurchaseOrderList();
        
        Product prod = new Product("Kobayashi", "TV", 999.99f);
        Product prod2 = new Product("Kobayashi", "DVD Player", 99.99f);
        Product prod3 = new Product("Kobayashi", "Video Camera", 399.99f);
        
        PurchaseOrder po1 = new PurchaseOrder("4da65d4a", "89qwe7q8ew", prod, 1, 1299.99f, "not paid");
        PurchaseOrder po2 = new PurchaseOrder("4da65d4a", "89qwe7q8ew", prod2, 1, 149.99f, "not paid");
        PurchaseOrder po3 = new PurchaseOrder("4da51sde", "89qwe72x3c", prod, 1, 1299.99f, "not paid");
        
        pol.add(po1);
        pol.add(po2);
        pol.add(po3);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(pol, System.out);
        marshaller.marshal(pol, new File("XMLResources/KobayashiManufacturer/KobayashiPurchaseOrders.xml"));
    }
}
