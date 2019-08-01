/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.view;

import com.icaballero.domain.User;
import com.icaballero.exception.ServicesException;
import com.icaballero.interfaces.services.IUserServices;
import com.icaballero.services.UserServesImpl;
import java.util.List;

/**
 *
 * @author ismael
 */
public class Main {
    
    
    
       public static void main(String[] args) {
           
           IUserServices service = new UserServesImpl();
           
           try{
               //service.insert("pepe", "pepito");
               //service.update(4, "gustavo", "garqgf");
               //service.delete(4);
               
               List<User> list = service.select();
               for (User user : list) {
                   System.out.println(user);
                   
               }
           }catch(ServicesException e){
               e.printStackTrace();
           }
           
           
        
    }
    
}
