/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session63;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author ismael
 */
public class PoolConexionesMysql {
    
    private static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("ismael23");
        ds.setUrl("jdbc:mysql://localhost:3306/sga?useSSL=false");
        
        //Definir el tamaña del pool de conexiones
        //Definimos 5
        ds.setInitialSize(5);
        
        return ds;
        
    }
    
    public static Connection getConnection() throws SQLException{
        
       
        return getDataSource().getConnection();
        
    }
    
    
}
