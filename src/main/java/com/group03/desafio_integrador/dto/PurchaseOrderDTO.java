package com.group03.desafio_integrador.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PurchaseOrderDTO {
    private Long buyerId;
    private List<ProductDTO> products;
}
