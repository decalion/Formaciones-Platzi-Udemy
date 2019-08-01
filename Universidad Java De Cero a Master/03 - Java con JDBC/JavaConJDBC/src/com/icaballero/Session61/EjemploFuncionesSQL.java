/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.Session61;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;


/**
 *
 * @author ismael
 */
public class EjemploFuncionesSQL {
    
    public static void main(String[] args) {
    
       // primeraFuncion();
        //segundaFundion();
        ejemploCursor();
    }
    
    
    
    private static void ejemploCursor(){
        OracleCallableStatement oraCallStmt = null;
        OracleResultSet deptResultSet = null;
        
        try{
            Connection con = Conexion.getConnection();
            
            oraCallStmt = (OracleCallableStatement) con.prepareCall("{? = call ref_cursor_package.get_dept_ref_cursor(?)}");
            oraCallStmt.registerOutParameter(1, OracleTypes.CURSOR);
            oraCallStmt.setInt(2, 200);
            oraCallStmt.execute();
            
            deptResultSet = (OracleResultSet) oraCallStmt.getCursor(1);
            
            while(deptResultSet.next()){
                System.out.println("ID _Departamento: " + deptResultSet.getInt(1));
                System.out.println("Nombre _Departamento: " + deptResultSet.getString(2));
                System.out.println("Ubicacion: " + deptResultSet.getInt(3));
                System.out.println();
            }
            
            oraCallStmt.close();
        }catch(Exception e){
            e.printStackTrace();;
        }
        
    }
    
    
    
    
    private static void primeraFuncion(){
        int empleadoId = 100;
      

        try {
            Connection con = Conexion.getConnection();
            CallableStatement cstm = null;
            Statement stmt = null;
            ResultSet rs = null;

            stmt = con.createStatement();
            double salarioMensual;

            //El primer ? correcponde al valor que va adevolver la funcion el 2n ? corresponde al valor de entrada d la funcion
            
            cstm = con.prepareCall("{ ? = call get_employee_salary(?) }");

            
        
            
            //Registramos los valores
            
           cstm.registerOutParameter(1, java.sql.Types.INTEGER);
            cstm.setInt(2, empleadoId);
            
     

            //Ejecutamos la funcion
            cstm.execute();
            
    
            
             //Obtenemos el resultado
           salarioMensual = cstm.getDouble(1);
            
            //Cerramos
            cstm.close();

           

            System.out.println("Empleado con id: " + empleadoId);
            System.out.println("Salario € " + salarioMensual);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
    
    private static void segundaFundion(){
        int empleadoId = 100;
        double incremento_Salario = 1.1;

        try {
            Connection con = Conexion.getConnection();
            CallableStatement cstm = null;
            Statement stmt = null;
            ResultSet rs = null;

            stmt = con.createStatement();
            


    
            cstm = con.prepareCall("{call set_employe_salary(?,?)}");
            
            //Registramos los valores
            
         
            cstm.setInt(1, empleadoId);
            cstm.setDouble(2, incremento_Salario);

            //Ejecutamos la funcion
            cstm.execute();
            
            String quey = "SELECT first_name, salary FROM employees "+ " WHERE employee_id = "+empleadoId;
            rs = stmt.executeQuery(quey);
            rs.next();

            System.out.println("Nombre: " + rs.getString(1));
            System.out.println("Salario nuevo: " + rs.getFloat(2));
            
            
            
            //Cerramos
            cstm.close();
            Conexion.close(con);
            Conexion.close(rs);


        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
}
