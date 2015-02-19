package model;

import java.util.HashMap;

public class ItemShippingStatusList{

	HashMap<Item, String> statusList;
	
	public ItemShippingStatusList(){
		statusList = new HashMap<Item, String>();
	}
	
	public String put(Item i, String status){
		if (status.compareTo("shipped") == 0 || status.compareTo("not shipped") == 0)
		{
			statusList.put(i, status);
			return status;
		}
		else
			return null;
	}
}
