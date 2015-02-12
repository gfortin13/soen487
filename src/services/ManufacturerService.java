package services;

import model.Product;
import model.PurchaseOrder;

public class ManufacturerService {

	
	
	/*This operation is called by the warehouse service. If the unit price is higher or equal to the
	defined price in the XML File, call produce() to produce this product; otherwise return
	false. Notice that produce() can only produce 100 units at a time. If the order is big,
	you have to call produce() several times. After successfully producing this order, record
	this order into an XML File and return true.*/
	public boolean processPurchaseOrder(PurchaseOrder aPO){
		//TODO - Get xmlPrice from file
		float xmlPrice = (float) 10.00;
		if (aPO.getUnitPrice() >= xmlPrice)
		{
			int remainingUnits = aPO.getQuantity();
			while (remainingUnits > 0)
			{
				if (remainingUnits < 100)
					produce(aPO.getProduct().getProductType(), remainingUnits);
				else
				{
					produce(aPO.getProduct().getProductType(), 100);
					remainingUnits = remainingUnits - 100;
				}
			}	
		}
			return false;
	}
		
	/*If the product name is from \DVD player", \video camera", or \TV", return the corre-
	sponding product information as dened in the XML le; otherwise return null.*/
	public Product getProductInfo(String aProdName){
		//TODO
		if (aProdName.compareTo("DVD Player") == 0 || aProdName.compareTo("Video Camera") == 0|| aProdName.compareTo("TV") == 0)
			//TODO - get Product info from file and return
			return new Product(null, aProdName, 0);
		else
			return null;
	}
		
		/*This operation is called by the warehouse service. The orderNum and the totalPrice
		should match a recorded order in the XML le. If you nd a match, you mark the
		matching order as \paid" in the XML le and return true. Otherwise, return false.*/
	public boolean receivePayment(String orderNum, float totalPrice){
		//TODO - get orderNum and totalPrice from xml file
		String xmlOrderNum = "temporaryNum";
		float xmlTotalPrice = (float)10.00;
		if (orderNum.compareTo(xmlOrderNum) == 0 || xmlTotalPrice == totalPrice)
		{
			//TODO - Write paid to XML File
			return true;
		}
		return false;
	}
		
		/*This is an internal method to simulate production. Called by processPurchaseOrder().
		Always returns true if the productName is \DVD player", \video camera", or \TV", and
		quantity  100; otherwise, return false.*/
	private boolean produce(String productName, int quantity){
		//TODO
		if ((productName.compareTo("DVD Player") == 0 || productName.compareTo("Video Camera") == 0|| productName.compareTo("TV") == 0) && quantity <= 100)
			return true;
		else
			return false;
	}
		
}
