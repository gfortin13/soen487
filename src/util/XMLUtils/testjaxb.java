package util.XMLUtils;

import services.KobayashiManufacturerService;
import services.WarehouseService;
import model.ItemList;
import model.Product;
import model.ProductList;

public class testjaxb {
    public static void main(String[] args){
        
    	KobayashiManufacturerService manService = new KobayashiManufacturerService();
        ProductList manProducts = manService.loadProducts();
        
        for (Product currentProduct : manProducts)
        {
        	System.out.println(currentProduct.getManufacturerName());
        	System.out.println(currentProduct.getProductType());
        	System.out.println(currentProduct.getUnitPrice());
        }
    	
    	WarehouseService warService = new WarehouseService();
        ItemList warProducts = warService.loadWarehouseItems();
        for (model.Item currentProduct : warProducts)
        {
        	System.out.println(currentProduct.getManufacturerName());
        	System.out.println(currentProduct.getProductType());
        	System.out.println(currentProduct.getUnitPrice());
        }
    	
    	
    }
}
