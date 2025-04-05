package com.bazaartech.InventoryManagement.repo;

import com.bazaartech.InventoryManagement.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByStoreIdAndProductId(Long storeId, Long productId);
    List<Inventory> findByStoreId(Long storeId);
}
