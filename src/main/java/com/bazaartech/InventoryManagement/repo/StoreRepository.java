package com.bazaartech.InventoryManagement.repo;

import com.bazaartech.InventoryManagement.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
