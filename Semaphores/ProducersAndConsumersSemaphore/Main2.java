import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class Main2 {
    public static void main(String[] args) {

        Queue<Object> queue= new LinkedList<>();
        int maxSize=6;
        Semaphore producerS= new Semaphore(maxSize);
        Semaphore consumerS= new Semaphore(0);

        Producer2 p1= new Producer2(maxSize,queue,"p1",producerS,consumerS);
        Producer2 p2= new Producer2(maxSize,queue,"p2",producerS,consumerS);
        Producer p3= new Producer(maxSize,queue,"p3");
        Producer p4= new Producer(maxSize,queue,"p4");
        Consumer2 c1= new Consumer2(maxSize,queue,"c1",producerS,consumerS);
        Consumer2 c2= new Consumer2(maxSize,queue,"c2",producerS,consumerS);
        Consumer2 c3= new Consumer2(maxSize,queue,"c3",producerS,consumerS);
        Consumer2 c4= new Consumer2(maxSize,queue,"c4",producerS,consumerS);
        Consumer2 c5= new Consumer2(maxSize,queue,"c5",producerS,consumerS);


        Thread t6= new Thread(p1);
        t6.start();
        Thread t7= new Thread(p2);
        t7.start();
        Thread t8= new Thread(p3);
        t8.start();
        Thread t9= new Thread(p4);
        t9.start();
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


    }
}
