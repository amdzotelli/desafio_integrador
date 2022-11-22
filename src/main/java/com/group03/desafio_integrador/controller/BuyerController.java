package com.group03.desafio_integrador.controller;

import com.group03.desafio_integrador.entities.Buyer;
import com.group03.desafio_integrador.entities.ShoppingCart;
import com.group03.desafio_integrador.service.interfaces.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v6/buyers")
public class BuyerController {

    @Autowired
    IBuyerService service;

    /**
     * Rota responsável por listar todos os compradores cadastrados na plataforma.
     * @author Amanda Zotelli
     * @return Retorna uma lista de Buyer.
     */
    @GetMapping
    public ResponseEntity<List<Buyer>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    /**
     * Rota responsável por trazer o perfil de um comprador, de acordo com o Id passado por parâmetro.
     * @author Amanda Zotelli
     * @return Retorna um Buyer.
     */
    @GetMapping("/profile/{buyerId}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable(value = "buyerId") Long buyerId) {
        return new ResponseEntity<>(service.getById(buyerId), HttpStatus.OK);
    }

    /**
     * Rota responsável por trazer a lista com as compras de um comprador, de acordo com o Id passado por parâmetro.
     * @author Amanda Zotelli
     * @return Retorna uma Lista de ShoppingCart.
     */
    @GetMapping(value = "/orders/list", params = {"buyerId"})
    public ResponseEntity<List<ShoppingCart>> getAllShoppingCart(@RequestParam("buyerId") Long buyerId) {
        List<ShoppingCart> cart = service.getAllBuyerShoppingCart(buyerId);
        if (cart.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
    }

}

