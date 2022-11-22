package com.group03.desafio_integrador.repository;

import com.group03.desafio_integrador.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findShoppingCartsByBuyer_BuyerId(Long buyerId);
}
