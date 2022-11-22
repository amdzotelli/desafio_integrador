package com.group03.desafio_integrador.controller;

import com.group03.desafio_integrador.entities.Buyer;
import com.group03.desafio_integrador.entities.InboundOrder;
import com.group03.desafio_integrador.service.interfaces.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
