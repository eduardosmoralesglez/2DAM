package com.example.demo;

import com.example.demo.hilos.MyThread;

public class Main2 {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        System.out.println("Arrancamos el hilo");
        thread.start();
        try {
            System.out.println("Hilo dormido");
            thread.sleep(5000);
            System.out.println("Hilo reanudado");
        } catch (Exception e) {
            System.out.println("El hilo fue interrumpido");
        }
        

    }
}
