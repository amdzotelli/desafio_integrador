package com.group03.desafio_integrador.service.interfaces;

import com.group03.desafio_integrador.entities.Buyer;
import com.group03.desafio_integrador.entities.ShoppingCart;

import java.util.List;

public interface IBuyerService {
    /**
     * Método responsável por retornar o comprador conforme Id informado.
     * @author Amanda Zotelli
     * @param id - Long
     * @return Retorna uma entidade do tipo Buyer.
     */
    Buyer getById(Long id);

    List<Buyer> getAll();

    List<ShoppingCart> getAllBuyerShoppingCart(Long buyerId);
}
