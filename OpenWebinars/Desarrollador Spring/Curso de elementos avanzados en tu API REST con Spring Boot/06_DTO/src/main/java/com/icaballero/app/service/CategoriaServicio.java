package com.icaballero.app.service;

import org.springframework.stereotype.Service;

import com.icaballero.app.modelo.Categoria;
import com.icaballero.app.repositories.CategoriaRepositorio;
import com.icaballero.app.service.base.BaseService;

@Service
public class CategoriaServicio extends BaseService<Categoria, Long, CategoriaRepositorio>{

}
