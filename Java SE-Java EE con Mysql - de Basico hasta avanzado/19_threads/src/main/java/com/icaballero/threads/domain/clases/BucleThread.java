/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.threads.domain.clases;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismael
 */
public class BucleThread extends Thread {

    public BucleThread(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            if (this.getName() == "HILO #1") {
                System.out.println("Ciclo en la posicion " + i * 100
                        + " PROCESO: " + this.getName());
            } else {
                System.out.println("Ciclo en la posicion " + i
                        + " PROCESO: " + this.getName());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BucleThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.out.println("Proceso: " + this.getName() + " Terminado");

    }

}
