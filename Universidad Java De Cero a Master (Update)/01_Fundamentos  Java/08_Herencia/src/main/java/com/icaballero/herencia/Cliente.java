/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.herencia;

import java.util.Date;

/**
 *
 * @author ismael
 */
public class Cliente extends Persona{
    
    private Integer idCliente;
    private Date fechaRegistro;
    private boolean vip;
    private static int contadorClientes = 0;

    public Cliente(Date fechaRegistro, boolean vip) {
        this.fechaRegistro = fechaRegistro;
        this.vip = vip;
        this.idCliente = ++contadorClientes;
    }
    

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    

    
}
