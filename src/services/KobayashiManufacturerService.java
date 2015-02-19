package services;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Product;
import model.ProductList;
import model.PurchaseOrder;
import model.PurchaseOrderList;

public class KobayashiManufacturerService {
	
	// IMPORTANT: WRITE RELATIVE PATH ON OWN MACHINE
	private final String PRODUCTSXMLPATH = "XMLResources/KobayashiManufacturer/KobayashiProducts.xml";
	private final String PURCHASEORDERSXMLPATH = "XMLResources/KobayashiManufacturer/KobayashiPurchaseOrders.xml";
	private ProductList products;
	private PurchaseOrderList purchaseOrders; 
	
	/*This operation is called by the warehouse service. If the unit price is higher or equal to the
	defined price in the XML File, call produce() to produce this product; otherwise return
	false. Notice that produce() can only produce 100 units at a time. If the order is big,
	you have to call produce() several times. After successfully producing this order, record
	this order into an XML File and return true.*/
	public boolean processPurchaseOrder(PurchaseOrder aPO){
		
		//Load the products, if the item does not occur in the xml return false
		loadProducts();
		if (!products.getProductList().contains(aPO.getProduct()))
			return false;
		
		//If the item exists in the xml, retrieve its price within the xml file
		float xmlPrice = products.getProductList().get(products.getProductList().indexOf(aPO.getProduct())).getUnitPrice();
		if (aPO.getUnitPrice() >= xmlPrice)
		{
			//If the xml price is less than or equal to the purchase order price, retrieve item quantity
			int remainingUnits = aPO.getQuantity();
			while (remainingUnits > 0)
			{
				if (remainingUnits < 100)
				{
					//If there are less than 100 units to make, make them and update remaining units
					produce(aPO.getProduct().getProductType(), remainingUnits);
					remainingUnits = 0;
				}
				else
				{
					//If there are 100 or more units, produce 100 and update the remaining quantity
					produce(aPO.getProduct().getProductType(), 100);
					remainingUnits = remainingUnits - 100;
				}
			}
			loadPurchaseOrders();
			purchaseOrders.add(aPO);
			updatePurchaseOrders();
			return true;
		}
			return false;
	}
		
	/*If the product name is from "DVD player", "video camera", or "TV", return the corre-
	sponding product information as defined in the XML file; otherwise return null.*/
	public Product getProductInfo(String aProdName){
		
		if (aProdName.compareTo("DVD Player") != 0 && aProdName.compareTo("Video Camera") != 0 && aProdName.compareTo("TV") != 0)
			return null;
		
		loadProducts();
		for (Product currentProduct : products.getProductList())
		{
			if (currentProduct.getProductType().compareTo(aProdName) == 0)
				return currentProduct;
		}
		return null;
	}
		
		/*This operation is called by the warehouse service. The orderNum and the totalPrice
		should match a recorded order in the XML file. If you find a match, you mark the
		matching order as "paid" in the XML file and return true. Otherwise, return false.*/
	public boolean receivePayment(String orderNum, float totalPrice){
		
		loadPurchaseOrders();
		
		for(PurchaseOrder currentPurchaseOrder: purchaseOrders.getPurchaseOrderList())
			if (currentPurchaseOrder.getOrderNum().compareTo(orderNum) == 0){
				if ((int)(currentPurchaseOrder.getUnitPrice() * currentPurchaseOrder.getQuantity()*100) == (int)(totalPrice*100))
				{
					currentPurchaseOrder.setPaymentStatus("paid");
					updatePurchaseOrders();
					return true;
				}
			}
		
		return false;
	}
		
		/*This is an internal method to simulate production. Called by processPurchaseOrder().
		Always returns true if the productName is "DVD player", "video camera", or "TV", and
		quantity <= 100; otherwise, return false.*/
	private boolean produce(String productName, int quantity){
		if ((productName.compareTo("DVD Player") == 0 || productName.compareTo("Video Camera") == 0|| productName.compareTo("TV") == 0) && quantity <= 100)
			return true;
		else
			return false;
	}
	
	
	/*
	 * This private method is used to load the Manufacturer product information from xml into objects.
	 */
	private ProductList loadProducts(){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(ProductList.class);
			Unmarshaller productListUnmarshaller = context.createUnmarshaller();
			products = (ProductList)productListUnmarshaller.unmarshal(new File(PRODUCTSXMLPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	/*
	 * This private method is used to save the Manufacturer product information to xml.
	 */
	private void updateProducts(){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(ProductList.class);
			Marshaller productListMarshaller = context.createMarshaller();
			productListMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			productListMarshaller.marshal(products, new File(PRODUCTSXMLPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * This private method is used to load the Manufacturer purchase order information from xml into objects.
	 */
	private PurchaseOrderList loadPurchaseOrders(){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(PurchaseOrderList.class);
			Unmarshaller purchaseOrderListUnmarshaller = context.createUnmarshaller();
			purchaseOrders = (PurchaseOrderList)purchaseOrderListUnmarshaller.unmarshal(new File(PURCHASEORDERSXMLPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return purchaseOrders;
	}
	
	/*
	 * This private method is used to save the Manufacturer purchase order information to xml.
	 */
	private void updatePurchaseOrders(){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(PurchaseOrderList.class);
			Marshaller purchaseOrderListMarshaller = context.createMarshaller();
			purchaseOrderListMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			purchaseOrderListMarshaller.marshal(purchaseOrders, new File(PURCHASEORDERSXMLPATH));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
		
}
