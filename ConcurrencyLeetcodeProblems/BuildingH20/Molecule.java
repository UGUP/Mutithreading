import javax.swing.*;
import java.util.concurrent.Semaphore;

public class Molecule implements  Runnable{

    private Semaphore oxygen;
    private Semaphore hydrogen;
    private int hydrogenCount=0;

    public Molecule(){
        this.hydrogen= new Semaphore(2);
        this.oxygen= new Semaphore(0);
    }

    public static void  oxygen(){
        System.out.println("O");
    }

    public static void hydrogen(){
        System.out.println("H");
    }
    @Override
    public void run() {
        try {
            hydrogen.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hydrogen();
        if(hydrogenCount==2){
            oxygen.release();
            hydrogenCount=0;
        }

        try {
            oxygen.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hydrogen.release();
        hydrogen.release();
    }
}
