package util.XMLUtils;

import services.KobayashiManufacturerService;
import model.Product;
import model.ProductList;

public class testjaxb {
    public static void main(String[] args){
        KobayashiManufacturerService service = new KobayashiManufacturerService();
        ProductList products = service.loadProducts();
        for (Product currentProduct : products)
        {
        	System.out.println(currentProduct.getManufacturerName());
        	System.out.println(currentProduct.getProductType());
        	System.out.println(currentProduct.getUnitPrice());
        }
    }
}
