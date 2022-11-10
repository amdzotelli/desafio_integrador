package com.group03.desafio_integrador.service;

import com.group03.desafio_integrador.advice.exeptions.NotFoundException;
import com.group03.desafio_integrador.entities.Warehouse;

public interface IWarehouseService {

    /**
     * Método responsável por retornar o armazem de acordo com o Id informado.
     * @author Gabriel Morais
     * @param id - Long
     * @return Warehouse - Retorna uma entidade do tipo Warehouse.
     * @throws NotFoundException
     */
    Warehouse getById(Long id) throws NotFoundException;
}
