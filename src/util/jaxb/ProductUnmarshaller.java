package util.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;


import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import services.KobayashiManufacturerService;
import services.WarehouseService;
import model.ItemList;
import model.Product;
import model.ProductList;

public class ProductUnmarshaller {
    public static void main(String[] args){
    	
		try {
			JAXBContext jc = JAXBContext.newInstance(ProductList.class);
		
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        ProductList products = (ProductList) unmarshaller.unmarshal(new File("XMLResources/KobayashiManufacturer/KobayashiProducts.xml"));
	        
	        System.out.println(products.getProductList().size());
	        for (Product currentProduct : products.getProductList())
	        {
	        	System.out.println(currentProduct.getManufacturerName());
	        	System.out.println(currentProduct.getProductType());
	        	System.out.println(currentProduct.getUnitPrice());
	        }
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
