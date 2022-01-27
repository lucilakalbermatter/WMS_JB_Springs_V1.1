package com.example.WMS_JB_Springs_V10.repository;

import com.example.WMS_JB_Springs_V10.model.Item;
import com.example.WMS_JB_Springs_V10.model.Warehouse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The Data Repository
 * 
 * @author pujanov
 *
 */
public class WarehouseRepository {

	
	public static List<Warehouse> WAREHOUSE_LIST = new ArrayList<Warehouse>();
	private static Set<Integer> WAREHOUSE_IDS = new HashSet<>();

	/**
	 * Load item records from the stock.json file
	 */
	static {
		// System.out.println("Loading items");
		BufferedReader reader = null;
		try {
			//ITEM_LIST.clear();
			WAREHOUSE_LIST.clear();

			reader = new BufferedReader(new FileReader("/Users/temporaryadmin/Documents/Project WMS/WMS_JB_Springs_V1.1/data/stock.json"));
			Object data = JSONValue.parse(reader);
			if (data instanceof JSONArray) {
				JSONArray dataArray = (JSONArray) data;
				for (Object obj : dataArray) {
					if (obj instanceof JSONObject) {
						JSONObject jsonData = (JSONObject) obj;
						Item item = new Item();
						item.setState(jsonData.get("state").toString());
						item.setCategory(jsonData.get("category").toString());
						String date = jsonData.get("date_of_stock").toString();
						// System.out.println("Item Date " + date);
						item.setDateOfStock(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date));
						// System.out.println(item);
						
						int jsonWarehouseId = Integer.parseInt(jsonData.get("warehouse").toString());
						
						if (!WAREHOUSE_IDS.contains(jsonWarehouseId)) {
							WAREHOUSE_IDS.add(jsonWarehouseId);
							
							Warehouse warehouse = new Warehouse(jsonWarehouseId);
							warehouse.addItem(item);
							WAREHOUSE_LIST.add(warehouse);
						} else {
							for(int i=0 ; i< WAREHOUSE_LIST.size(); i++) {
								if(WAREHOUSE_LIST.get(i).getId() == jsonWarehouseId) {
									WAREHOUSE_LIST.get(i).addItem(item);
									//break;
								}
							}
						}
						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * Get All items available in the repository
	 * 
	 * @return
	 */

	  public static List<Item> getAllItems() { 
		  
		  List<Item> allItems = new ArrayList<Item>();
		  
		  //for(Warehouse warehouse : WAREHOUSE_LIST) {
		  for(int i=0; i < WAREHOUSE_LIST.size(); i++) {
			  List<Item> itemsWarehouse = new ArrayList<Item>(); 
			  for(Item item : WAREHOUSE_LIST.get(i).getStock()) {
				  item.setWarehouse(WAREHOUSE_LIST.get(i).getId());
				  itemsWarehouse.add(item);
			  }
			  allItems.addAll(itemsWarehouse);
		  }
		  return allItems; 
		  }
	 
	// By Warehouse
		/**
		 * Get the list of unique warehouse IDs
		 * 
		 * @return
		 */

		public static Set<Integer> getWarehouses() {
			Set<Integer> warehouses = new HashSet<Integer>();
			for (Warehouse warehouse : WAREHOUSE_LIST) {
				warehouses.add(warehouse.getId());
			}
			return warehouses;
		}  
	  
		/**
		 * Get the list of all items in a specific warehouse
		 * 
		 * @param warehouse
		 * @return
		 */
		public static List<Item> getItemsByWarehouse(int warehouse) {
			return getItemsByWarehouse(warehouse, getAllItems());
		}

		/**
		 * Get the list of items related to a specific warehouse in a given master-list
		 * 
		 * @param warehouse
		 * @return
		 */
		public static List<Item> getItemsByWarehouse(int warehouse, List<Item> masterList) {
			List<Item> items = new ArrayList<Item>();
			for (Item item : masterList) {
				if (item.getWarehouse() == warehouse) {
					items.add(item);
				}
			}
			return items;
		}
		
		
	// By Category
	/**
	 * Get the list of unique Categories
	 * 
	 * @return
	 */
	
		public static Set<String> getCategories() {
		  Set<String> categories = new HashSet<String>(); 
		  for (Item item : getAllItems()) {
			  categories.add(item.getCategory()); 
		  } 
		  return categories; 
		  }
	 

	/**
	 * Get the list of all items of a specific category
	 * 
	 * @param category
	 * @return
	 */
	
		public static List<Item> getItemsByCategory(String category) {
		  return getItemsByCategory(category, getAllItems());}


	/**
	 * Get the list of items of a specific category in a given master-list
	 * 
	 * @param category
	 * @return
	 */
	public static List<Item> getItemsByCategory(String category, List<Item> masterList) {
		List<Item> items = new ArrayList<Item>();
		for (Item item : masterList) {
			if (item.getCategory().equalsIgnoreCase(category)) {
				items.add(item);
			}
		}
		return items;
	}

	public static List<Warehouse> getWarehouseList(){
		return WAREHOUSE_LIST;
	}

	public static Set<Integer> getWarehouseIds() {
		return WAREHOUSE_IDS;
	}

	public static List<Item> getSearchItems(String keyword) {
		List<Item> searchedItem = new ArrayList<>();

		for(Item item : getAllItems()){
			if(item.toString().toLowerCase().contains(keyword)){
				searchedItem.add(item);
			}
		}
		return searchedItem;
	}
}
