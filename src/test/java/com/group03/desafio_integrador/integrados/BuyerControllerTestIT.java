package com.group03.desafio_integrador.integrados;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.group03.desafio_integrador.entities.*;
import com.group03.desafio_integrador.repository.BuyerRepository;
import com.group03.desafio_integrador.repository.ShoppingCartRepository;
import com.group03.desafio_integrador.utils.mocks.TestsMocks;
import lombok.extern.log4j.Log4j2;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Log4j2
@SpringBootTest
@AutoConfigureMockMvc
class BuyerControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BuyerRepository repository;

    @Autowired
    private ShoppingCartRepository cartRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll_returnListBuyers_whenSuccess() throws Exception {
        List<Buyer> buyers = repository.findAll();

        ResultActions response = mockMvc.perform(
                get("/api/v6/buyers")
                        .contentType(MediaType.APPLICATION_JSON) );

        response.andExpect(status().isOk());
        assertThat(buyers).asList();
    }

    @Test
    void getById_returnBuyerProfile_whenIdIsValid() throws Exception {
      Integer buyerId = Math.toIntExact(TestsMocks.mockBuyer().getBuyerId());

        ResultActions response = mockMvc.perform(get("/api/v6/buyers/profile/1")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
               .andExpect(jsonPath("$.buyerId", CoreMatchers.is(buyerId)));
    }

    @Test
    void getById_throwsNotFoundError_whenIdIsNotValid() throws Exception {
       ResultActions response = mockMvc.perform(
                get("/api/v6/buyers/profile/800")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isNotFound())
                  .andExpect(jsonPath("$.message", CoreMatchers.is("Buyer not found!")));
    }

    @Test
    void getBuyerCart_returnShoppingCartList_whenShoppingCartExist() throws Exception {
//        Long buyerId = TestsMocks.mockBuyer().getBuyerId();
//
//        cartRepository.findShoppingCartsByBuyer_BuyerId(buyerId);

        ResultActions response = mockMvc.perform(
                get("/api/v6/buyers/orders/list?buyerId=1")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }

    @Test
    void getBuyerCart_returnStatusNoContent_whenShoppingCartDoesNotExist() throws Exception {

        ResultActions response = mockMvc.perform(
                get("/api/v6/buyers/orders/list?buyerId=140")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isNoContent());
    }

    @Test
    void getBuyerCart_throwsBuyerNotFound_whenBuyerDoesNotExist() throws Exception {

        ResultActions response = mockMvc.perform(
                get("/api/v6/buyers/orders/list?buyerId=200")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isNotFound());
    }

}