package com.icaballero.rest.service;

import org.springframework.stereotype.Service;

import com.icaballero.rest.modelo.Categoria;
import com.icaballero.rest.repos.CategoriaRepositorio;
import com.icaballero.rest.service.base.BaseService;

@Service
public class CategoriaServicio extends BaseService<Categoria, Long, CategoriaRepositorio>{

}
