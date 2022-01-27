package com.example.WMS_JB_Springs_V10.controller;

import com.example.WMS_JB_Springs_V10.model.Item;
import com.example.WMS_JB_Springs_V10.repository.WarehouseRepository;
import com.example.WMS_JB_Springs_V10.service.UserService;
import com.example.WMS_JB_Springs_V10.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping ( "/warehouse/getWarehouses")
    public Set<Integer> getWarehouses(){
        return warehouseService.getWarehouses();
    }

    @GetMapping ( "/warehouse/getAllItems")
    public List<Item> getAllItems(){
        return warehouseService.getAllItems();
    }

    @GetMapping ("/warehouse/getAllItems/{warehouseId}")
    public List<Item> getItemsByWarehouse(@PathVariable("warehouseId") int warehouse) {
        return warehouseService.getItemsByWarehouse(warehouse);
    }

    @GetMapping ("/warehouse/getCategories")
    public Set<String> getCategories(){
        return warehouseService.getCategories();
    }

    @GetMapping ( "/warehouse/getItemsByCategory/{category}")
    public List<Item> getItemsByCategory(@PathVariable("category") String category) {
        return warehouseService.getItemsByCategory(category);
    }

    @GetMapping ( "/warehouse/searchItem/{keyword}")
    public List<Item> getSearchItems(@PathVariable("keyword") String keyword) {
        return warehouseService.getSearchItems(keyword);
    }



}
