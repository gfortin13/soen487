package util.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.Customer;
import model.Item;
import model.ItemList;

public class CustomerMarshaller {
	public static void main(String[] args) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(Customer.class);
		
		/*Unmarshaller unmarshaller = jc.createUnmarshaller();
		Cars cars = (Cars) unmarshaller.unmarshal(new File("cars.xml"));*/
		
		
		Customer cust = new Customer(55, "Joe", "home", "", "mtl", "qc", "11111", "Canada");
		
		
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(cust, System.out);
		marshaller.marshal(cust, new File("XMLResources/Customer/Customer.xml"));
	}
}
