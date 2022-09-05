package com.luxsoft.commonutils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.luxsoft.model.Order;
import com.opencsv.CSVReader;


public class ReadCSV{

//	ApplicationProperties appProps = Environment.INSTANCE.getApplicationProperties();


	public List<Order> getOrderDetails() throws IOException {

		List<Order> listorders = null;
		try {
			listorders = new ArrayList<Order>();
			
			System.out.println("sot path si "+ApplicationConstants.SOT_PATH);

			CSVReader csvreader = new CSVReader(new FileReader(ApplicationConstants.SOT_PATH));
			String[] nextline;

			while ((nextline = csvreader.readNext()) != null) {

				if (nextline != null) {
					listorders.add(getOneOrder(nextline));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listorders;
	}
	
	public Order getOrderDetailsFromSOT(int orderId) throws IOException {

		Order orderDetails = null;
		
	
	
		List<Order> orders = getOrderDetails();
		
		for(Order order : orders) {
			if(orderId == order.getOrderId()) {
				return order;
			}
		}
		return orderDetails;
	}

	

	private static Order getOneOrder(String[] params) {

		Order order = null;
		int orderId = 0;
		int level = 0;
		try {
			if (params[0] != null || params[0].isEmpty() == true) {
				orderId = Integer.parseInt(params[0]);
			}
			if (params[1] != null || params[0].isEmpty() == true) {
				level = Integer.parseInt(params[1]);
			}
			String code = params[2];
			String parent = params[3];
			String description = params[4];
			String thisItemIncludes = params[5];
			String thisItemAlsoIncludes = params[6];
			String rulings = params[7];
			String thisItemExcludes = params[8];
			String referenceCode = params[9];
			order = new Order(orderId, level, code, parent, description, thisItemIncludes, thisItemAlsoIncludes,
					rulings, thisItemExcludes, referenceCode);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

}
