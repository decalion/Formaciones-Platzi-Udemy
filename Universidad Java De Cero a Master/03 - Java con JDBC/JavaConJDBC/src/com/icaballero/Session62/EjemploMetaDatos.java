/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session62;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import oracle.jdbc.OracleResultSetMetaData;

/**
 *
 * @author ismael
 */
public class EjemploMetaDatos {
    
    
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            con = Conexion.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employees");
            
            OracleResultSetMetaData rsOracle = (OracleResultSetMetaData) rs.getMetaData();
            
            if(rsOracle == null){
                System.out.println("Metadatos No disponibles");
                
            }else{
                int columnCount = rsOracle.getColumnCount();
                System.out.println("Numero de columnas: " + columnCount);
                
                for (int i = 1; i < columnCount; i++) {
                    System.out.print("Nombre Columna: " + rsOracle.getColumnName(i));
                    System.out.print(" ,Tipo Columna: " + rsOracle.getColumnTypeName(i));
                    
                    switch(rsOracle.isNullable(i)){
                        case OracleResultSetMetaData.columnNoNulls:
                            System.out.print(", No accepta nulos");
                            break;
                        case OracleResultSetMetaData.columnNullable:
                            System.out.print(", Si accepta nulos");
                            break;
                        case OracleResultSetMetaData.columnNullableUnknown:
                            System.out.print(", valor nulo desconocido");
                            break;
                        
                            
                    }
                    System.out.println();
                
                }
                
                
            }
         
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Conexion.close(con);
            Conexion.close(rs);
        }
        
    }
    
    
}
