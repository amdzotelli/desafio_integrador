package com.group03.desafio_integrador.service;

import com.group03.desafio_integrador.advisor.exceptions.NotFoundException;
import com.group03.desafio_integrador.entities.Buyer;
import com.group03.desafio_integrador.entities.ShoppingCart;
import com.group03.desafio_integrador.repository.BuyerRepository;
import com.group03.desafio_integrador.repository.ShoppingCartRepository;
import com.group03.desafio_integrador.service.interfaces.IBuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyerService implements IBuyerService {

    private final BuyerRepository repository;

    private final ShoppingCartRepository cartRepository;

    /**
     * Método responsável por retornar o comprador conforme Id informado.
     * @author Amanda Zotelli
     * @param id - Long
     * @return Retorna uma entidade do tipo Buyer.
     * @throws NotFoundException - NotFoundException
     */
    @Override
    public Buyer getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Buyer not found!"));
    }

    /**
     * Método responsável por retornar todos os compradores cadastrados na plataforma.
     * @author Amanda Zotelli
     * @return Retorna uma Lista da entidade do tipo Buyer.
     */
    @Override
    public List<Buyer> getAll() {
        return repository.findAll();
    }

    /**
     * Método responsável por retornar uma Lista com as compras de um comprador, conforme Id informado.
     * @author Amanda Zotelli
     * @param id - Long
     * @return Retorna uma Lista da entidade do tipo ShoppingCart. Se não houverem compras, retorna um status 204 No Content.
     */
    @Override
    public List<ShoppingCart> getAllBuyerShoppingCart(Long buyerId) {
        return cartRepository.findShoppingCartsByBuyer_BuyerId(buyerId);
    }

}
