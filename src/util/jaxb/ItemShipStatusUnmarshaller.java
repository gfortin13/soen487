package util.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.ItemShippingStatus;
import model.ItemShippingStatusList;
import model.Product;
import model.ProductList;

public class ItemShipStatusUnmarshaller {
    public static void main(String[] args){
    	
		try {
			JAXBContext jc = JAXBContext.newInstance(ItemShippingStatusList.class);
		
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        ItemShippingStatusList issl = (ItemShippingStatusList) unmarshaller.unmarshal(new File("XMLResources/Warehouse/WarehouseShippingStatusList.xml"));
	        
	        System.out.println(issl.getItemShippingStatusList().size());
	        for (ItemShippingStatus iss : issl.getItemShippingStatusList())
	        {
	        	System.out.println(iss.getItem().getManufacturerName());
	        	System.out.println(iss.getItem().getProductType());
	        	System.out.println(iss.getItem().getUnitPrice());
	        	System.out.println(iss.getStatus());
	        }
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
