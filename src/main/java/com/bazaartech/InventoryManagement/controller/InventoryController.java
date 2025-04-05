package com.bazaartech.InventoryManagement.controller;

import com.bazaartech.InventoryManagement.model.*;
import com.bazaartech.InventoryManagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/store")
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        return ResponseEntity.ok(inventoryService.createStore(store));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(inventoryService.createProduct(product));
    }

    @PostMapping("/inventory")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.updateInventory(inventory));
    }

    @GetMapping("/inventory/{storeId}")
    public ResponseEntity<List<Inventory>> getInventory(@PathVariable Long storeId) {
        return ResponseEntity.ok(inventoryService.getInventoryByStore(storeId));
    }
}
