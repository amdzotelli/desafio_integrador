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

    @GetMapping
    public ResponseEntity<List<Buyer>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @GetMapping("/profile/{buyerId}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable(value = "buyerId") Long buyerId) {
        return new ResponseEntity<>(service.getById(buyerId), HttpStatus.OK);
    }

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

