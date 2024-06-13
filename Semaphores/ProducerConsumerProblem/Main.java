import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class Main {
    public static void main(String[] args) {

        Queue<Object> queue= new LinkedList<>();
        int maxSize=6;

        Consumer c1= new Consumer(queue,"c1");
        Consumer c2= new Consumer(queue,"c2");
        Consumer c3= new Consumer(queue,"c3");
        Consumer c4= new Consumer(queue,"c4");
        Consumer c5= new Consumer(queue,"c5");
        Producer p1= new Producer(maxSize,queue,"p1");
       // Producer p2= new Producer(maxSize,queue,"p2");
//        Producer p3= new Producer(maxSize,queue,"p3");
//        Producer p4= new Producer(maxSize,queue,"p4");


        Thread t1= new Thread(c1);
        t1.start();
        Thread t2= new Thread(c2);
        t2.start();
        Thread t3= new Thread(c3);
        t3.start();
        Thread t4= new Thread(c4);
        t4.start();
        Thread t5 = new Thread(c5);
        t5.start();
        Thread t6= new Thread(p1);
        t6.start();
//        Thread t7= new Thread(p2);
//        t7.start();
//        Thread t8= new Thread(p3);
//        t8.start();
//        Thread t9= new Thread(p4);
//        t9.start();

    }
}
