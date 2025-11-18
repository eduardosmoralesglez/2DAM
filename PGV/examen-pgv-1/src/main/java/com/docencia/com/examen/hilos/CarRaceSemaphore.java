package com.docencia.com.examen.hilos;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class CarRaceSemaphore implements Runnable {
    private String name;
    private int distance = 0;
    private int goal;
    private static AtomicBoolean winnerDeclared = new AtomicBoolean(false);
    private Semaphore semaphore = new Semaphore(1, true);
    
    /**
     * Constructor Thread
     * @param name 
     * @param goal
     */
    public CarRaceSemaphore(String name, int goal) {
        this.name = name;
        this.goal = goal;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(1);
            Random random = new Random();
            while (!winnerDeclared.get()) {
                Thread.sleep(300);
                if (distance >= goal && !winnerDeclared.get()) {
                    winnerDeclared.set(true);
                    System.out.println("Ganador "+name);
                    break;
                }
                int paso = random.nextInt(10);
                distance += paso;
                System.out.println(name + " lleva " +distance+", la meta es "+goal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release(1);
        }
        
    }

    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════");
        System.out.println("    🏁 CARRERA DE COCHES 🏁");
        System.out.println("   Rayo-McQueen vs Mate");
        System.out.println("═══════════════════════════════════════");
        
        int raceGoal = 100;
        
        Thread rayoMcQueen = new Thread(new CarRaceSemaphore("Rayo-McQueen", raceGoal));
        Thread mate = new Thread(new CarRaceSemaphore("Mate", raceGoal));

        rayoMcQueen.start();
        mate.start();

        try {
            rayoMcQueen.join();
            mate.join();
            
            System.out.println("\n═══════════════════════════════════════");
            System.out.println("        🏁 CARRERA TERMINADA 🏁");
            System.out.println("═══════════════════════════════════════");
            
        } catch (InterruptedException e) {
            System.out.println("La carrera fue interrumpida!");
        }
    }
    
    
}
