package com.icaballero.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.icaballero.app.models.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
