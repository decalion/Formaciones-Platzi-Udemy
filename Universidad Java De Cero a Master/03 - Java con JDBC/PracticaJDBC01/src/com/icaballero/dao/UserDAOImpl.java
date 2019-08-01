/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.dao;

import com.icaballero.domain.User;
import com.icaballero.exception.DAOException;
import java.sql.Connection;
import com.icaballero.interfaces.dao.IUserDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ismael
 */
public class UserDAOImpl implements IUserDAO{
    
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private final String SQL_INSERT="INSERT INTO usuario(usuario,password) VALUES(?,?)";
    private final String SQL_UPDATE="UPDATE usuario SET usuario=?, password=? WHERE id_usuario=?";
    private final String SQL_DELETE="DELETE FROM usuario WHERE id_usuario=?";
    private final String SQL_SELECT="SELECT id_usuario,usuario,password FROM usuario ORDER BY id_usuario";
 
    
    /**
     * Constructor que recibe la conexion
     * @param con 
     */
    public UserDAOImpl(Connection con) {
        this.con = con;
    }

    /**
     * Metodo para insertar datos en la tabla user
     * @param user
     * @param password
     * @return
     * @throws DAOException 
     */
    @Override
    public int insert(String user, String password) throws DAOException {
        int rows = -1;
        try{
            
            
            stmt = con.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, user);
            stmt.setString(index++, password);
            System.out.println("Se va ha ejecutado la siguiente query: "+ SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Se han insertado los siguientes registros: " +rows);
            
            DBConnection.close(con);
            DBConnection.close(stmt);
            
        }catch(Exception e){
            throw new DAOException("Error al insertar datos DAOException");
        }
        return rows;
    }

    /**
     * Metodo para actualizar datos en la tabla user
     * @param id_user
     * @param nombre
     * @param password
     * @return
     * @throws DAOException 
     */
    @Override
    public int update(int id_user, String nombre, String password) throws DAOException {
       
        int rows = -1;
        try{
            stmt = con.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, nombre);
            stmt.setString(index++, password);
            stmt.setInt(index++, id_user);
            System.out.println("Se va ha ejecutado la siguiente query: "+ SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Se han actualizado los siguientes registros: " +rows);
            
            DBConnection.close(con);
            DBConnection.close(stmt);
        }catch(Exception e){
            throw new DAOException("Error al actializar los datos DAOException");
            
        }
        
        
        
        return rows;
    }

    @Override
    public int delete(int id_user) throws DAOException {
        int rows = -1;
        
        try{
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_user);
            System.out.println("Se va ha ejecutado la siguiente query: "+ SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Se han eliminado los siguientes registros: " +rows);
             DBConnection.close(con);
            DBConnection.close(stmt);
        }catch(Exception e){
            
            throw new DAOException("Error al elminar el registro DAOException");
        }
        
        return rows;
    }

    @Override
    public List<User> select() throws DAOException {
        
        List<User> list = new ArrayList<User>();
        User user = null;
        
      try{
          
          stmt = con.prepareStatement(SQL_SELECT);
          rs = stmt.executeQuery();
          
          while(rs.next()){
              
              user = new User();
              user.setId_user(rs.getInt(1));
              user.setUsuario(rs.getString(2));
              user.setPassword(rs.getString(3));
              
              list.add(user);
          }
          
          DBConnection.close(con);
          DBConnection.close(stmt);
          DBConnection.close(rs);
          
          
      }catch(Exception e){
          throw new DAOException("Error al realizar la consulta DAOException");
      }
      
        
        
        return list;
    }

}
