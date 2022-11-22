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

    /**
     * Método responsável por retornar todos os compradores cadastrados na plataforma.
     * @author Amanda Zotelli
     * @return Retorna uma Lista da entidade do tipo Buyer.
     */
    List<Buyer> getAll();

    /**
     * Método responsável por retornar uma Lista com as compras de um comprador, conforme Id informado.
     * @author Amanda Zotelli
     * @param id - Long
     * @return Retorna uma Lista da entidade do tipo ShoppingCart.
     */
    List<ShoppingCart> getAllBuyerShoppingCart(Long buyerId);
}
