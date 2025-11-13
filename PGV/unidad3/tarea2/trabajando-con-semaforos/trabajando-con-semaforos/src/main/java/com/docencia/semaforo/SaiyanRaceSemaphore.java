package com.docencia.semaforo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class SaiyanRaceSemaphore implements Runnable {
    private final String name;
    private int distance = 0;
    private static final int GOAL = 100;
    private static final AtomicBoolean WINNER_DECLARED = new AtomicBoolean(false);

    // Semaphore acquire()/release()
    private static final Semaphore semaphore = new Semaphore(1, true);

    public SaiyanRaceSemaphore() {
        this.name = "";
    }

    public SaiyanRaceSemaphore(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (!WINNER_DECLARED.get() && distance < GOAL) {
                semaphore.acquire();
                if (WINNER_DECLARED.get()) {
                    break;
                }
                int step = ThreadLocalRandom.current().nextInt(1, 11);
                distance += step;
                System.out.println(name + " avanza " + step + " metros. Distancia total: " + distance + " metros.");
                if (distance >= GOAL) {
                    WINNER_DECLARED.set(true);
                    System.out.println(name + " ha ganado la carrera!");
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread saiyan1 = new Thread(new SaiyanRaceSemaphore("Goku"));
        Thread saiyan2 = new Thread(new SaiyanRaceSemaphore("Vegeta"));

        saiyan1.start();
        saiyan2.start();

        saiyan1.join();
        saiyan2.join();
    }
}
