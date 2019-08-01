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
public class PoolConexionesOracle {
    
    
    
    private static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUsername("hr");
        ds.setPassword("hr");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

        //Definir el tamaña del pool de conexiones
        //Definimos 5
        ds.setInitialSize(5);

        return ds;

    }

    public static Connection getConnection() throws SQLException {

        return getDataSource().getConnection();

    }
}
