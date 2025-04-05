package com.bazaartech.InventoryManagement.service;

import com.bazaartech.InventoryManagement.model.*;
import com.bazaartech.InventoryManagement.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Inventory updateInventory(Inventory inventory) {
        Inventory existing = inventoryRepository.findByStoreIdAndProductId(inventory.getStore().getId(), inventory.getProduct().getId());
        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + inventory.getQuantity());
            return inventoryRepository.save(existing);
        } else {
            return inventoryRepository.save(inventory);
        }
    }

    public List<Inventory> getInventoryByStore(Long storeId) {
        return inventoryRepository.findByStoreId(storeId);
    }
}
