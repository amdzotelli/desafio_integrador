package com.group03.desafio_integrador.integrados;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.group03.desafio_integrador.dto.BatchStockDTO;
import com.group03.desafio_integrador.entities.*;
import com.group03.desafio_integrador.entities.entities_enum.CategoryEnum;
import com.group03.desafio_integrador.repository.BuyerRepository;
import com.group03.desafio_integrador.repository.InboundOrderRepository;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    private Batch mockBatch;

    @BeforeEach
    void setUp() {

        Batch mockBatchList = TestsMocks.createBatch();
        mockBatch = TestsMocks.mockBatch();

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

        response.andExpect(status().isOk());
               // .andExpect(jsonPath("$.batchId", CoreMatchers.is(batchId)));
    }

    @Test
    void getById_throwsNotFoundError_whenIdIsNotValid() throws Exception {
       ResultActions response = mockMvc.perform(
                get("/api/v6/buyers/profile/800")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isNotFound());
        //        .andExpect(jsonPath("$.message", CoreMatchers.is("This category is not valid")));
    }

    @Test
    void getCartProducts_returnCartProduct_whenShoppingCartExist() throws Exception {
        List<CartProduct> shoppingCart = cartProductRepository.findAllByShoppingCart(shoppingCartId);

        ResultActions response = mockMvc.perform(
                get("/api/v1/fresh-products/orders/1")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }

    @Test
    void getCartProducts_returnStatusNoContent_whenShoppingCartDoesNotExist() throws Exception {
        List<CartProduct> shoppingCart = cartProductRepository.findAllByShoppingCart(shoppingCartId);

        ResultActions response = mockMvc.perform(
                get("/api/v1/fresh-products/orders/1")
                        .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }
}