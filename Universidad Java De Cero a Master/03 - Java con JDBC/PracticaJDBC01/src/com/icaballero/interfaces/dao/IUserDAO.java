/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.interfaces.dao;

import com.icaballero.domain.User;
import com.icaballero.exception.DAOException;
import java.util.List;

/**
 *
 * @author ismael
 */
public interface IUserDAO {
    
    public int insert(String user , String password) throws DAOException;
    public int update(int id_user, String nombre,String password) throws DAOException;
    public int delete(int id_user)throws DAOException;
    public List<User> select()throws DAOException;
    
}
