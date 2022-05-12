package utilities.APIHelpers.Serialization;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import Pojo.SellingList;
import Pojo.ShippingOptions;
import payloads.SellingPayloadConstants;

public class SellingListHelper {
	
	
	
	
	// Method to Serialize Java Pojo class and convert into JSON Payload String
	
	public static String getPayload() {
		String payload = "";
		
		
		List<ShippingOptions> shippingOptions = new ArrayList<ShippingOptions>();
			shippingOptions.add(new ShippingOptions(
				
				SellingPayloadConstants.getFirstShippingOptionType(),
				SellingPayloadConstants.getFirstShippingOptionPrice(),
				SellingPayloadConstants.getFirstShippingOptionMethod(),
				SellingPayloadConstants.getFirstShippingOptionShippingId())
				
				); 
		
			shippingOptions.add( new ShippingOptions(
				
				SellingPayloadConstants.getSecondShippingOptionType(),
				SellingPayloadConstants.getSecondShippingOptionPrice(),
				SellingPayloadConstants.getSecondShippingOptionMethod(),
				SellingPayloadConstants.getSecondShippingOptionShippingId())
				
				);
		
		
		
		List<String> description = new ArrayList<String>();
		
			description.add(SellingPayloadConstants.getFirstDescprition());
			description.add(SellingPayloadConstants.getSecondDescription());
		
		
		
		
		List<Integer> paymentMethod = new ArrayList<Integer>();
		
			paymentMethod.add(SellingPayloadConstants.getFirstPaymentMethod());
			paymentMethod.add(SellingPayloadConstants.getSecondPaymentMethod());
		
		//Initializing Selling List through using a Constructor
			
		SellingList list = new SellingList(
				SellingPayloadConstants.getCategory(),
				SellingPayloadConstants.getTitle(), 
				SellingPayloadConstants.getSubtitle(), 
				description,
				SellingPayloadConstants.getStartPrice(),
				SellingPayloadConstants.getReservedPrice(),
				SellingPayloadConstants.getBuyNowPrice(),
				SellingPayloadConstants.getDuration(),
				SellingPayloadConstants.getPickup(),
				shippingOptions,
				paymentMethod
				);
		
		
		//Serializing Class object to JSON String.
		Gson gson = new Gson();
		payload = gson.toJson(list);
		
		
		
		
		
		
		return payload;
		
	}



}
