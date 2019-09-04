/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.threads;

import com.icaballero.threads.domain.clases.BucleThread;
import com.icaballero.threads.domain.clases.LeerArchivoThread;
import com.icaballero.threads.domain.clases.ThreadRunnable;

/**
 *
 * @author ismael
 */
public class Principal {
    
    public static void main(String[] args) {
        Thread t1= new BucleThread("HILO #1");
        Thread t2= new BucleThread("HILO #2");
        t1.start();
        t2.start();
        
        LeerArchivoThread leer = new LeerArchivoThread("HILO #0");
        leer.start();
        
        ThreadRunnable t3 = new ThreadRunnable();
        Thread hilo3 = new Thread(t3);
        hilo3.start();
        
        
    }
    
}
