/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.interfaces.services;

import com.icaballero.domain.User;
import com.icaballero.exception.ServicesException;
import java.util.List;

/**
 *
 * @author ismael
 */
public interface IUserServices {
    
    public int insert(String user , String password) throws ServicesException;
    public int update(int id_user, String nombre,String password) throws ServicesException;
    public int delete(int id_user)throws ServicesException;
    public List<User> select() throws ServicesException;
    
}
