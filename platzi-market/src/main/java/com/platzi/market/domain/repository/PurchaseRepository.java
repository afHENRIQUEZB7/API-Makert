package com.platzi.market.domain.repository;

import com.platzi.market.domain.dto.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    // traer las lista de compra realizadas por un cliente
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
