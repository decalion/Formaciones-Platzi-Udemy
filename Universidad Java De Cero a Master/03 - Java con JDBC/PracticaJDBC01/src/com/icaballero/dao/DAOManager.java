/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.dao;

import com.icaballero.interfaces.dao.IUserDAO;
import java.sql.Connection;

/**
 *
 * Clase Factoria para controlar la capa de datos(DAO)
 * @author ismael
 */
public class DAOManager {
    
    private Connection con = null;

    /**
     * Constructor que recibe la conexion
     * @param con 
     */
    public DAOManager(Connection con) {
        
        this.con = con;
    }
    
    /**
     * Devuelve un objeto de tipo IuserDAO
     * @return 
     */
    public IUserDAO getIuserDAO(){
        
        return new UserDAOImpl(con);
    }
    
    
    
}
