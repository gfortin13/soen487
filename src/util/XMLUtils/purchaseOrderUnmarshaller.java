package util.XMLUtils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Product;
import model.ProductList;
import model.PurchaseOrder;
import model.PurchaseOrderList;

public class purchaseOrderUnmarshaller {
	public static void main(String[] args){
		try {
			JAXBContext jc = JAXBContext.newInstance(PurchaseOrderList.class);
		
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        PurchaseOrderList pol = (PurchaseOrderList) unmarshaller.unmarshal(new File("XMLResources/KobayashiManufacturer/KobayashiPurchaseOrders.xml"));
	        
	        System.out.println(pol.getPurchaseOrderList().size());
	        for (PurchaseOrder cpo : pol.getPurchaseOrderList())
	        {
	        	System.out.println(cpo.getCustomerRef());
	        	System.out.println(cpo.getOrderNum());
	        	System.out.println(cpo.getPaymentStatus());
	        }
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
