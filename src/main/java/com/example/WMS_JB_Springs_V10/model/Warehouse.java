package com.example.WMS_JB_Springs_V10.model;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private int id;
    private List<Item> stock;

    //Constructor
    public Warehouse(int warehouseId) {
        this.id = warehouseId;
        this.stock = new ArrayList<Item>();
    }

    public int getId() {
        return id;
    }

    //The occupancy method will not take any argument and will return an integer representing the number of items in stock
    public int occupancy() {
        return stock.size();
    }

    //The addItem method will take an instance of Item as an argument. This method should simply add the given object to the stock property.
    public void addItem(Item newItem) {
        stock.add(newItem);
    }

    //The search method will search the items in the current warehouse and will return the list of matching items according to the searchTerm passed.
    public List<Item> search(String searchTerm) {
        List<Item> result = new ArrayList<Item>();
        for (Item item : getStock()) {
            if (searchTerm.toLowerCase().equals(item.toString())) {
                result.add(item);

            }
        } return result;
    }

    public List<Item> getStock() {
        return this.stock;
    }


}





