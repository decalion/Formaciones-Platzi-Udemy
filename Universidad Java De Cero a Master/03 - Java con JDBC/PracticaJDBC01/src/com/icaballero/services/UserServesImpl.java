/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.services;

import com.icaballero.dao.DAOManager;
import com.icaballero.dao.DBConnection;
import com.icaballero.domain.User;
import com.icaballero.exception.ServicesException;
import com.icaballero.interfaces.dao.IUserDAO;
import com.icaballero.interfaces.services.IUserServices;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ismael
 */
public class UserServesImpl implements IUserServices {

        private DAOManager manager = null;
        private Connection con = null;
        private IUserDAO userDAO = null;
    
    
    public UserServesImpl() {
        
        
    }


    @Override
    public int insert(String user, String password) throws ServicesException {
        int rows = -1;
        try{
        con = DBConnection.getConnection();
        manager = new DAOManager(con);
        userDAO = manager.getIuserDAO();
        rows = userDAO.insert(user, password);
        
         }catch(Exception e){
             throw new ServicesException("Error al insertar los datos ServicesException");
         }
        return rows;
    }

    @Override
    public int update(int id_user, String nombre, String password) throws ServicesException {
        int rows = -1;
        try{
        con = DBConnection.getConnection();
        manager = new DAOManager(con);
        userDAO = manager.getIuserDAO();
        rows = userDAO.update(id_user, nombre, password);
        
         }catch(Exception e){
             throw new ServicesException("Error al actualizar los datos ServicesException");
         }
        return rows;
    }

    @Override
    public int delete(int id_user) throws ServicesException {
               int rows = -1;
        try{
        con = DBConnection.getConnection();
        manager = new DAOManager(con);
        userDAO = manager.getIuserDAO();
        rows = userDAO.delete(id_user);
        
         }catch(Exception e){
             throw new ServicesException("Error al Eliminar  los datos ServicesException");
         }
        return rows;
    }

    @Override
    public List<User> select() throws ServicesException {
        List<User> list = new ArrayList<User>();
        try{
        con = DBConnection.getConnection();
        manager = new DAOManager(con);
        userDAO = manager.getIuserDAO();
        list = userDAO.select();
        
         }catch(Exception e){
             throw new ServicesException("Error al Consultar los datos  los datos ServicesException");
         }
        return list;
    }
    
    
    
     
    
    
}
