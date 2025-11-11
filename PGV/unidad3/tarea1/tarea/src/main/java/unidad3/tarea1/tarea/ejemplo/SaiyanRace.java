package unidad3.tarea1.tarea.ejemplo;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class SaiyanRace implements Runnable {
    private String name;
    private int distance = 0;
    private int goal = 100;
    //private static volatile boolean winnerDeclared = false;
    private static AtomicBoolean winnerDeclared = new AtomicBoolean();

    public SaiyanRace(String name) {
        this.name = name;
    }

    public SaiyanRace(String name, int goal ) {
        this.name = name;
        this.goal = goal;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (distance < goal && !winnerDeclared.get()) {
            int step = random.nextInt(10) + 1; // Avance aleatorio de 1 a 10
            distance += step;
            System.out.println(name + " avanzó " + step + " metros. Distancia total: " + distance + " metros.");
            if (distance >= goal && !winnerDeclared.get()) {
                winnerDeclared.set(true);
                System.out.println(name + " ha ganado la carrera!");
            }
            try {
                Thread.sleep(500); // Pausa entre pasos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Thread goku = new Thread(new SaiyanRace("Goku"));
        Thread vegeta = new Thread(new SaiyanRace("Vegeta"));
        Thread tortuga = new Thread(new SaiyanRace("Tortuga", 25));

        goku.start();
        vegeta.start();
        tortuga.start();
    }
}