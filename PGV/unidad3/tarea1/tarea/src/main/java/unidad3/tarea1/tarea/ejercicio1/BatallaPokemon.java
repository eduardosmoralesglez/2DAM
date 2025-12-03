package unidad3.tarea1.tarea.ejercicio1;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BatallaPokemon {
    private volatile boolean juegoTerminado = false;
    private int hpPikachu = 100;
    private int hpCharmander = 100;
    private String turno = "Pikachu";
    private ReentrantLock m;
    private Condition turnoCambio;

    public void atacar(String atacante, int hpOponente) {
        try {
            Random random = new Random();
            int danio = random.nextInt(20)+5;
            System.out.println(atacante + " ataca con " + danio + " de daño. HP rival: " + hpOponente);
            if (hpOponente <= 0 && !juegoTerminado) {
                juegoTerminado = true;
                System.out.println(atacante + " ha ganado la batalla!");
            }
                Thread.sleep(random.nextInt(200,600));
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    
    public void hiloPikachu() {
        try {
            while (!juegoTerminado) {
                m.lock();
                while (turno != "Pikachu" && !juegoTerminado) {
                    wait(turnoCambio.awaitNanos(m.getHoldCount()));
                    if (juegoTerminado) {
                        m.unlock();
                        break;
                    }
                }
                atacar("Pikachu", hpCharmander);
                turno = "Charmander";
                turnoCambio.signal();
                m.unlock();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

        public void hiloCharmander() {
        try {
            while (!juegoTerminado) {
                m.lock();
                while (turno != "Charmander" && !juegoTerminado) {
                    wait(turnoCambio.awaitNanos(m.getHoldCount()));
                    if (juegoTerminado) {
                        m.unlock();
                        break;
                    }
                }
                atacar("Charmander", hpPikachu);
                turno = "Pikachu";
                turnoCambio.signal();
                m.unlock();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    

}
