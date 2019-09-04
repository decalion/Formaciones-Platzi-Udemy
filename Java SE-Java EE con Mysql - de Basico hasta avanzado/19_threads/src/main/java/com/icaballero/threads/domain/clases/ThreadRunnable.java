/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.threads.domain.clases;

/**
 *
 * @author ismael
 */
public class ThreadRunnable implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setName("HILO #4");
        System.out.println(Thread.currentThread().getName());
    }
    
    
    
}
