package com.example.WMS_JB_Springs_V10.service;

import com.example.WMS_JB_Springs_V10.model.Item;
import com.example.WMS_JB_Springs_V10.model.Warehouse;
import com.example.WMS_JB_Springs_V10.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class WarehouseService {

    public Set<Integer> getWarehouses(){
        return WarehouseRepository.getWarehouseIds();
    }

    public List<Item> getAllItems(){
        return WarehouseRepository.getAllItems();
    }

    public List<Item> getItemsByWarehouse(int warehouse) {
      return WarehouseRepository.getItemsByWarehouse(warehouse);
    }

    public Set<String> getCategories() {
        return WarehouseRepository.getCategories();
    }

    public List<Item> getItemsByCategory(String category){
        return WarehouseRepository.getItemsByCategory(category);
    }

    public List<Item> getSearchItems(String keyword) {
    return WarehouseRepository.getSearchItems(keyword);
    }
}
