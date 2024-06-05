public class HelloPrinter implements Runnable{

    @Override
    public void run(){
        System.out.println("Hello "+" The Thread name is "+Thread.currentThread().getName());
    }
}
