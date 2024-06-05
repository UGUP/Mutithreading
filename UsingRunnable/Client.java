public class Client {

    public static void main(String[] args) {
        System.out.println("Hello the Thread is "+Thread.currentThread().getName());
        HelloPrinter hello= new HelloPrinter();
        Thread thread= new Thread(hello);
        thread.start();

    }
}
