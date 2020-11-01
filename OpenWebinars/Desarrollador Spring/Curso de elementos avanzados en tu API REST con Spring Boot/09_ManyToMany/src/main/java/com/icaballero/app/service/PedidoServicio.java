package com.icaballero.app.service;

import org.springframework.stereotype.Service;

import com.icaballero.app.modelo.Pedido;
import com.icaballero.app.repositories.PedidoRepositorio;
import com.icaballero.app.service.base.BaseService;

@Service
public class PedidoServicio extends BaseService<Pedido, Long, PedidoRepositorio> {

}
