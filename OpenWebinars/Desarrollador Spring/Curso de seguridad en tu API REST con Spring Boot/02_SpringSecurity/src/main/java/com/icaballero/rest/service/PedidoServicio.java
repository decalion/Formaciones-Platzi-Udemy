package com.icaballero.rest.service;

import org.springframework.stereotype.Service;

import com.icaballero.rest.modelo.Pedido;
import com.icaballero.rest.repos.PedidoRepositorio;
import com.icaballero.rest.service.base.BaseService;

@Service
public class PedidoServicio extends BaseService<Pedido, Long, PedidoRepositorio> {

}
